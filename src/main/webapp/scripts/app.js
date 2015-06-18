'use strict';

angular.module('itemsApp', ['ngResource', 'ngRoute', 'ui.bootstrap'])
    .config(function ($routeProvider) {
        $routeProvider.when('/', {
            controller: 'ItemCtrl'
        }).otherwise({
            redirectTo: '/'
        });
    });
