/**
 * Created by lauearo on 26/05/2017.
 */
define([], function () {
    'use strict';

    function config($routeProvider, $locationProvider) {
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
    }

    config.$inject = ['$routeProvider', '$locationProvider'];
    return config;
});
