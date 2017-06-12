/**
 * Created by lauearo on 01/06/2017.
 */
define(['config/menu'], function (menuList) {
    'use strict';

    function siderbarController($scope) {
        $scope.menuList = menuList.menu;

        for(var m in $scope.menuList){
            if(m.default){
                $scope.selectedMenu=m.name;
                break;
            }
        }

        $scope.menuClick = function (selectedMenu) {
            $scope.selecedMenu = selectedMenu;
        }
    }

    siderbarController.$inject = ["$scope"];
    return siderbarController;
});