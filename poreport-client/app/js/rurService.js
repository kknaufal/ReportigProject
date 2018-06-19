'user strict';
(function () {
    angular.module('app').service('rurService', rurService);

    rurService.$inject = ['$http'];
    function rurService($http) {

        var parentURL = 'http://localhost:8080/';
        var thisObj = this;
        var toDos = [];

        
        thisObj.getAll = function (searchParam) {
            var employeeId = searchParam.selectedEmployee? searchParam.selectedEmployee.value:0;
            var projectId = searchParam.selectedProject? searchParam.selectedProject.value:0;
            return get('/Resources/'+employeeId+'/'+projectId+'/'+
            searchParam.searchFromDate.getTime()+'/'+searchParam.searchToDate.getTime(), 'GET');
        };

        thisObj.getResourceHours = function (searchParam) {
            var employeeId = searchParam.selectedEmployee? searchParam.selectedEmployee.value:0;
            var projectId = searchParam.selectedProject? searchParam.selectedProject.value:0;
            return get('/ResourcesHours/'+employeeId+'/'+projectId+'/'+
            searchParam.searchFromDate.getTime()+'/'+searchParam.searchToDate.getTime(), 'GET');
        };

        thisObj.getTimesheetReports = function (searchParam) {
            return get('/Timesheets/'+
            searchParam.searchFromDate.getTime()+'/'+searchParam.searchToDate.getTime(), 'GET');
        };

        thisObj.getParentProjects = function(projectName){            
            return get('/Projects/'+projectName, 'GET');
        };

        thisObj.getEmployees = function(employeeName){            
            return get('/Employees/'+employeeName, 'GET');
        };

        thisObj.getLoggedUser = function(){
            return get('/user','GET');
        };

        function get(url, ACTION) {
            return $http({
                method: ACTION,
                url: /**parentURL +**/ url,
                //timeout: 1 * 10 * 1000,
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            });
        }

    }

})();