'use strict';

angular.module('app', ['ngRoute'])

    .controller("mainController", function mainController($scope) {

    })

    .config(function ($routeProvider, $locationProvider) {
        $locationProvider.html5Mode(true);

        $routeProvider
            .when('/', {
                templateUrl: "view/frontPage.html",
                controller: "frontPageController",
                controllerAs: "frontPageController"
            })
            .otherwise({redirectTo: '/'});
    });