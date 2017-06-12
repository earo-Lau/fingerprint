/**
 * Created by lauearo on 26/05/2017.
 */

define([], function () {
    'use strict';

    function institutionController($scope, $http) {

        $http.get('/ins/1', {
                headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}
            })
            .then(function (data) {
                $scope.institution = $.extend(data.data, {
                    'edit': false
                });
            });

        $scope.edit = function () {
            $scope.institution.edit = true;
        };

        $scope.update = function () {
            $http.put('/ins/1', $scope.institution)
                .then(function (data) {
                    $scope.institution.edit = false;
                });
        }
    }

    institutionController.$inject = ['$scope', '$http'];
    return institutionController;
});