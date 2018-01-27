'use strict';

angular.module('app')
    .controller('frontPageController', function ($scope, $http) {

        /* Example call to backend */
        $scope.responseData = [];
        $http.get('/get/example').then((res) => {
            console.log(res.data);
            $scope.responseData = res.data;
        }).catch((err) => {
            console.log("ERROR:");
            console.log(err);
        });
    });