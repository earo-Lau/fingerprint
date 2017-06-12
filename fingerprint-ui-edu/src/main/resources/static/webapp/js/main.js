/**
 * Created by lauearo on 26/05/2017.
 */
require.config({
    // baseUrl: '/webapp/js',
    paths: {
        'angular': 'lib/angular-1.6.4',
        'boostrap': 'lib/bootstrap-3.3.7-dist/js/bootstrap.min',
        'socketjs': 'lib/socket/sockjs.min',
        'stomp': 'lib/socket/stomp.min',
        'jquery': 'lib/maruti/jquery.min',
        'maruti': 'lin/maruti',
        'controller': 'controllers',
        'service': 'services'
    },
    shim: {
        'boostrap': {
            dept: ['jquery']
        }
    }
});

require(['app'], function (app) {
    'use strict';

    angular.bootstrap(document, ['myApp']);
});