'user strict';
(function () {
    angular.module('app')
        .controller('RURController', RURController);
    RURController.$inject = ['$scope', 'rurService'];

    function RURController($scope, rurService) {
        var vm = this;
        var endLocalDate = new Date();
        var lastWeekEnd = endLocalDate.setTime(endLocalDate.getTime() + ((6 - endLocalDate.getDay()) - 7) * 24 * 60 * 60 * 1000);
        var lastWeekStart = endLocalDate.setTime(endLocalDate.getTime() - 6 * 24 * 60 * 60 * 1000);
        vm.gridMessage= '';
        vm.selectionByDate = 'lastWeek';
        vm.selectionBy = 'Manager';
        vm.exportDisabled = true;
        //vm.projects = [{display: 'All',value: '-1'}]

        vm.gridOptions = {
            enableSorting: false,
            columnDefs: [
                { field: 'month', visible:false},  
                { field: 'weekEndingDate', visible:false},  
                { field: 'username', displayName:'Name' },                
                { field: 'project' },
                { field: 'sbu', displayName:'SBU' },
                { field: 'system' },
                { field: 'sum', displayName: 'Project Task Hours',cellFilter: 'number: 2', cellClass:'grid-column-number' },
                { field: 'bench', visible:false },
                { field: 'OtherHrs', visible:false },
                { field: 'holidays', visible:false },
                { field: 'absencesCount', displayName: 'Leaves(Hours)',cellFilter: 'number: 2', cellClass:'grid-column-number' },                
                { field: 'absencesComment', displayName: 'Comment' },
                { field: 'billableHrs' , visible:false},
                { field: 'nonBillableHrs' , visible:false}                
            ],
            enableGridMenu: false,
            enableSelectAll: false,
            exporterExcelFilename: 'ResourceUtilization.xls',
            exporterCsvFilename: 'ResourceUtilization.csv',
            
            // exporterFieldCallback: function (grid, row, col, input) {
            //     return input;
            // },
            onRegisterApi: function (gridApi) {
                vm.gridApi = gridApi;
            }
        };

        vm.searchParam = {};

        $scope.$watch(function watchSelectionByType(secope) {
            return (vm.selectionBy);
        },
            function watchSelectionByType(newValue, oldValue) {
                console.log('watchSelectionByType invoked :', newValue);
                vm.employeeText = null;
                vm.projectText = null;
                if (newValue === 'Manager') {
                    vm.searchParam.selectedProject = undefined;
                } else {
                    vm.searchParam.selectedEmployee = undefined;
                }

            }
        );

        $scope.$watch(function watchSelectionByDate(secope) {
            return (vm.selectionByDate);
        },
            function handleselectionByDate(newValue, oldValue) {
                console.log('watchSelectionByDate invoked :', newValue);
                if (newValue === 'lastWeek') {
                    vm.disableDate = true;
                    vm.searchParam.searchFromDate = new Date(lastWeekStart);
                    vm.searchParam.searchToDate = new Date(lastWeekEnd);
                } else {
                    vm.disableDate = false;
                    vm.searchParam.searchFromDate = new Date(lastWeekStart);
                    vm.searchParam.searchToDate = new Date(lastWeekEnd);
                }

            }
        );

        vm.export = function ($event) {
            var myElement = angular.element(document.querySelectorAll(".custom-csv-link-location"));
            console.log(vm.gridApi.exporter);
            vm.gridApi.exporter.csvExport('all', 'all', myElement);
            $event.preventDefault();
            //vm.gridApi.exporter.excelExport('all', 'all', myElement);

        };

        vm.search = function () {
            //vm.searchParam.id = vm.selectedEmployee.value;
            vm.gridStatusVisible = true;
            rurService.getAll(vm.searchParam).then(function (data) {
                console.log('get all success ', data);
                //vm.gridStatusVisible = data.data.length > 0 ? '' : 'No data found';
                vm.gridStatusVisible=false;
                vm.gridOptions.data = data.data;
                if(data.data.length>0){
                    vm.exportDisabled=false;
                    vm.gridMessage = '';
                }else{
                    vm.exportDisabled=true;
                    vm.gridMessage = 'Data not found';
                }
            }, function (error) {
                vm.gridStatusVisible = false;
                vm.gridMessage = 'Error on result, Data not found';
                console.log('Error from getAllTodo', error);
            });
        };

        vm.getParentProjects = function (projectName) {
            vm.projects = rurService.getParentProjects(projectName).then(function (data) {
                return data.data.map(function (item) {
                    return {
                        display: item.projectName,
                        value: item.projectId
                    };
                }) || [];
            },
                function (error) {
                    console.log('error from projects : ', error);
                    return [{
                        display: 'Error',
                        value: '0'
                    }];

                });
        };

        vm.getEmployees = function (employeeName) {

            vm.employees = rurService.getEmployees(employeeName).then(function (data) {
                return data.data.map(function (employee) {
                    return {
                        display: employee.username,
                        value: employee.userId
                    };
                }) || [];
            },
                function (error) {
                    console.log('error from getiing employees : ', error);
                    return [{
                        display: 'Error',
                        value: '0'
                    }];

                });
        };


        function getAllToDo() {
            rurService.getAll().then(function (data) {
                console.log('get all success ', data);
                vm.gridOptions.data = data.data;
            }, function (error) {
                console.log('Error from getAllTodo');
            });
        }
    }
})();