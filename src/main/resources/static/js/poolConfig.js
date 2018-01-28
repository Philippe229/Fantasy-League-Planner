'use strict';

angular.module('app')
    .controller('poolConfigController', function ($scope, $http) {

        $scope.setConfig = function () {
            let data = {
                attackerAssists: $scope.attackerAssists,
                attackerGoals: $scope.attackerGoals,
                defenderAssists: $scope.defenderAssists,
                defenderGoals: $scope.defenderGoals,
            };

            $http.post("/post/poolConfig", data).then((res) => {
                $scope.playersMap = res.data;
            }).catch((err) => {
                console.log("ERROR:");
                console.log(err);
            });
        };

    });