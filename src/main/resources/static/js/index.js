'use strict';

angular.module('app', ['ngRoute'])

    .controller("mainController", function mainController($scope) {

    })

    .config(function ($routeProvider, $locationProvider) {
        $locationProvider.html5Mode(true);

        $routeProvider
            .when('/', {templateUrl: "view/frontPage.html"}) // TODO controller
            .when('/poolConfig', {templateUrl: "view/poolConfig.html"}) // TODO controller
            .otherwise({redirectTo: '/'});
    });