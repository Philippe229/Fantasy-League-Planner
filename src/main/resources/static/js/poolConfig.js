'use strict';

angular.module('app')
    .controller('poolConfigController', function ($scope, $http) {

        $scope.setConfig = function() {
            let data = {
                attackerAssists: $scope.attackerAssists,
                attackerGoals: $scope.attackerGoals,
                defenderAssists: $scope.defenderAssists,
                defenderGoals: $scope.defenderGoals,
            };

            // TODO remove
            let map = {};
            map["ayyyy"] = 12345;
            map["lmao"] = 54321;
            $scope.testMap = map;

            $http.post("/post/poolConfig", data).then((res) => {
               console.log(res);
            }).catch((err) => {
                console.log("ERROR:");
                console.log(err);
            });
        };

    });