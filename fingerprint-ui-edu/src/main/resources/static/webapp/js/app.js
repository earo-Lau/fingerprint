/**
 * Created by lauearo on 26/05/2017.
 */
define([
    'config/config',
    'services/searchService',
    'controller/siderbarController',
    'controller/institutionController'
], function (config,
             searchService,
             siderbarController,
             institutionController) {

    'use strict';

    var app = angular.module('myApp', ['ngRoute', 'ngResource']);

    app.config(config);
    app.service('searchService', searchService);
    app.controller('institutionController', institutionController);
    app.controller('siderbarController', siderbarController);

    return app;
});

