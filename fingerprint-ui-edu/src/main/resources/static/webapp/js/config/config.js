/**
 * Created by lauearo on 26/05/2017.
 */
define([], function () {
    'use strict';

    function config($routeProvider, $locationProvider, $httpProvider) {
        $routeProvider
            .when('/institution', {
                templateUrl: '/webapp/views/institution.html',
                controller: 'institutionController'
            })
            .otherwise({redirectTo: '/institution'});

        $locationProvider.html5Mode({
            enable: true,
            requireBase: false
        });

        $httpProvider.interceptors.push('resourceInterceptor');
    }

    config.$inject = ['$routeProvider', '$locationProvider', '$httpProvider'];
    return config;
});
