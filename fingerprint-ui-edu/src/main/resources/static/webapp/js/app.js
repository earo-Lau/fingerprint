/**
 * Created by lauearo on 26/05/2017.
 */
define([
    'config/config',
    'config/resourceInterceptors',
    'services/profileService',
    'services/institutionService',
    'services/searchService',
    'controller/siderbarController',
    'controller/institutionController'
], function (config,
             resourceInterceptor,
             profileService,
             institutionService,
             searchService,
             siderbarController,
             institutionController) {

    'use strict';

    var app = angular.module('myApp', ['ngRoute', 'ngResource']);

    app.config(config);

    app.service('searchService', searchService);
    app.service('profileService', profileService);
    app.service('institutionService', institutionService);
    app.service('resourceInterceptor', resourceInterceptor);

    app.controller('institutionController', institutionController);
    app.controller('siderbarController', siderbarController);

    return app;
});