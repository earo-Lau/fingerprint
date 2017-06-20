/**
 * Created by lauearo on 26/05/2017.
 */

define([], function () {
    'use strict';

    function institutionController($scope, institutionService, profileService) {
        profileService.get(null, function (profileInfo) {
            var roles = new Array();
            $.each(profileInfo.roles, function (i, r) {
                roles.push(r.name);
            });

            $scope.user={
                roles: roles
            };

            $scope.instId = profileInfo.institutionId;
            $scope.getInfo();
        });

        $scope.getInfo = function () {
            institutionService.get({
                insId: $scope.instId
            }, function (institution) {
                $scope.institution = $.extend(institution, {
                    'edit': false
                });
            });
        };

        $scope.edit = function () {
            $scope.institution.edit = true;
        };

        $scope.update = function () {
            institutionService.put(
                {insId: $scope.instId},
                $scope.institution,
                function (result) {
                    $scope.institution.edit = false;
                });
        }
    }

    institutionController.$inject = ['$scope', 'institutionService', 'profileService'];
    return institutionController;
});