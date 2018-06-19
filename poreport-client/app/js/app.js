'user strict';
(function () {/* , */
    var angular = require('angular');
    require('angular-ui-router');
    require('jquery');        
    require('bootstrap');    
    require('angular-animate');    
    require('angular-aria');    

    require('angular-ui-grid');
    require('angular-material');
    require('angular-messages');

    //require('./systemCommon/csv');   
    //require('./systemCommon/excel-builder');
    //require('pdfmake');       
    //require('lodash');    
    //require('jszip');    
    //require('excel-builder');
    //require('jszip');
    
    require('../partialDist/templateCachePartials'); 
    

    angular.module('app', ['ui.router','ui.grid','ngMaterial','ngMessages',
     'ui.grid.selection', 'ui.grid.exporter', 'ui.grid.moveColumns','poPartials'])
     .config(function($stateProvider, $urlRouterProvider, $httpProvider){
        $httpProvider.interceptors.push('loadingInterceptor');
        $urlRouterProvider.otherwise('/rurreports');
        $stateProvider
        .state('rurreports', {
            url: '/rurreports',
            templateUrl: '/partials/rurReports.html',
            controller: 'RURController',
            controllerAs:'rurCtrl'
        })
        .state('tsreport', {
            url: '/tsreport',
            templateUrl: '/partials/tsReports.html',
            controller: 'tsrController',
            controllerAs:'tsrCtrl'
        })
        .state('rhreport', {
            url: '/rhreport',
            templateUrl: '/partials/rhReports.html',
            controller: 'RHRController',
            controllerAs:'rhrCtrl'
        });
     });
    require('./system/systemController');
    require('./system/loadingInterceptor');
    require('./rurController');
    require('./timesheetReport/tsrController');
    require('./resourcesHoursReport/rhrController');
    require('./rurService');
})();