'user strict';
(function () {
    angular.module('app').controller('systemController', systemController);

    systemController.$inject = ['$scope', 'rurService'];

    function systemController($scope, rurService) {
        var thisObj = this;

        rurService.getLoggedUser().then(function (userData) {
            $scope.loggedUser = userData.data.name;
        }, function (error) {
            console.log('Error from system controller on getting user data: ', error);
        });
        //load employeeData and projectData
        rurService.getEmployees('load');
        rurService.getParentProjects('load');
        $scope.tab = 1;
        thisObj.setTab = function (newTab) {
            $scope.tab = newTab;
        };

        thisObj.isSet = function (tabNum) {
            return $scope.tab === tabNum;
        };
    }
})();