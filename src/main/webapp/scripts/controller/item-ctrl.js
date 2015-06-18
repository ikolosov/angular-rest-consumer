'use strict';

angular.module('itemsApp').controller(
    'ItemCtrl',
    function ($scope, ItemService) {

        $scope.updateItems = function () {
            var opId = 'Items update ';
            $scope.itemzzz = ItemService.query(
                {},
                function success() {
                    console.log(opId + 'succeeded.');
                },
                function err() {
                    alert(opId + ' failed!');
                });
        };

        $scope.addItem = function () {
            var opId = 'New item submission ';
            ItemService.add(
                {name: $scope.itemForm.inputName, flag: $scope.itemForm.inputFlag},
                function success() {
                    console.log(opId + 'succeeded.');
                    $scope.updateItems();
                },
                function err() {
                    alert(opId + ' failed!');
                });
        };

        $scope.deleteItem = function (item) {
            var opId = 'Item deletion ';
            item.$delete(
                {},
                function success() {
                    console.log(opId + 'succeeded.');
                    $scope.updateItems();
                },
                function err() {
                    alert(opId + ' failed!');
                });
        };

        $scope.updateItems();
    });
