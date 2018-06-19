'user strict';
(function () {
    angular.module('app')
        .controller('tsrController', tsrController);
    tsrController.$inject = ['$scope', 'rurService'];

    function tsrController($scope, rurService) {
        var vm = this;
        var endLocalDate = new Date();
        var lastWeekEnd = endLocalDate.setTime(endLocalDate.getTime() + ((6 - endLocalDate.getDay() - 1) - 7) * 24 * 60 * 60 * 1000);
        var lastWeekStart = endLocalDate.setTime(endLocalDate.getTime() - 4 * 24 * 60 * 60 * 1000);
        vm.gridMessage= '';
        vm.selectionByDate = 'lastWeek';
        vm.exportDisabled = true;

        vm.gridOptions = {
            enableSorting: false,
            columnDefs: [
                { field: 'dateRange', displayName: 'Date', width: '*', visible: false },
                { field: 'userName', displayName: 'User Name', width: '*' },
                { field: 'tfs', displayName: 'TFS', width: '*' },
                { field: 'client', width: '*' },
                { field: 'description', displayName: 'Description', width: '*' },
                { field: 'effort', displayName: 'Actual Effort', width: '*',cellFilter: 'number: 2', cellClass:'grid-column-number' }

            ],
            enableGridMenu: false,
            enableSelectAll: false,
            exporterExcelFilename: 'TimesheetReports.xls',
            exporterCsvFilename: 'TimesheetReports.csv',
            // exporterFieldCallback: function (grid, row, col, input) {
            //     return input;
            // },
            onRegisterApi: function (gridApi) {
                vm.gridApi = gridApi;
            }
        };

        //vm.employees = [{ id: '66673', name: 'Geetha C' }, { id: '69663', name: 'Sajeena S' }];
        vm.searchParam = {};



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
            rurService.getTimesheetReports(vm.searchParam).then(function (data) {
                console.log('get all success ', data);
                //vm.gridStatus = data.data.length > 0 ? '' : 'No data found';
                vm.gridStatusVisible = false;
                vm.gridOptions.data = data.data;
                if(data.data.length>0){
                    vm.exportDisabled=false;
                    vm.gridMessage ='';
                }else{
                    vm.gridMessage ='Data not found';
                    vm.exportDisabled=true;
                }
            }, function (error) {
                vm.gridStatusVisible = false;
                vm.gridMessage = 'Error on result, Data not found';
                console.log('Error from getAllTodo', error);
            });
        };




    }
})();