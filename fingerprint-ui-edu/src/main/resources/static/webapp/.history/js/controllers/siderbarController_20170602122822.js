/**
 * Created by lauearo on 01/06/2017.
 */
define(['config/menu'], function (menuList) {
    'use strict';

    function siderbarController($scope) {
        $scope.menuList = menuList.menu;

        for(var i = 0; i < $scope.menuList; i++){
            if($scope.menuList[i].default){
                $scope.selectedMenu=$scope.menuList[i].name;
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