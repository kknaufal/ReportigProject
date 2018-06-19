(function(){
    'use strict';
    angular.module('app').service('loadingInterceptor', loadingInterceptor);
    loadingInterceptor.$inject = ['$q', '$rootScope', '$log'];
    function loadingInterceptor($q, $rootScope, $log){
        return {
            request: function(config) {
                if(config.url.includes('Resources')||config.url.includes('Timesheets')){
                    $rootScope.loading = true;
                }                
                //$log.info('request : ', config);
                //console.log('request : ', config);
                return config;
            },
            requestError: function(rejection) {
                $rootScope.loading = false;
                $log.error('Request error:', rejection);
                return $q.reject(rejection);
            },
            response: function(response) {
                $rootScope.loading = false;
                //console.log('response :', response);
                return response;
            },
            responseError: function(rejection) {
                $rootScope.loading = false;
                $log.error('Response error:', rejection);
                return $q.reject(rejection);
            }
        };
    }
})();