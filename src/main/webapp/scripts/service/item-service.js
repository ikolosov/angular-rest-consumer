'use strict';

angular.module('itemsApp').service('ItemService',
    function ItemService($resource) {
        return $resource(
            'rest/item/:itemId',
            {itemId: '@id'},
            {
                query: {
                    method: 'GET',
                    isArray: true
                },
                add: {
                    method: 'POST',
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    transformRequest: function (obj) {
                        var str = [];
                        for (var p in obj)
                            str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                        return str.join("&");
                    },
                    data: {name: 'default name', flag: false}
                },
                delete: {
                    method: 'DELETE'
                }
            });
    });
