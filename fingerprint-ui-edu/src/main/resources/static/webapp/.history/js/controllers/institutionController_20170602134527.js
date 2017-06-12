/**
 * Created by lauearo on 26/05/2017.
 */

define([], function () {
    'use strict';

    function institutionController($scope, $http) {

        $http.get('/ins/1', {})
            .then(function (data) {
                $scope.institution = $.extend(data.data, { 'edit': false });
                console.info("institution >>>", $scope.institution);
            });

        $scope.edit = function () {
            $scope.institution.edit = true;
        };

        $scope.update = function () {
            $http.put('/ins', {
                params: {

                }
            }).then(function (data) {

            });
        }
    }

    institutionController.$inject = ['$scope', '$http'];
    return institutionController;
});
