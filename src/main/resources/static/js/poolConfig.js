'use strict';

angular.module('app')
    .controller('poolConfigController', function ($scope, $http) {

        $scope.setConfig = function() {
            let data = {
                attackerAssists: $scope.attackerAssists,
                attackerGoals: $scope.attackerGoals,
                defenderAssists: $scope.defenderAssists,
                defenderGoals: $scope.defenderGoals,
                goaltenderWins: $scope.goaltenderWins,
                goaltenderShutouts: $scope.goaltenderShutouts,
                goaltenderAssists: $scope.goaltenderAssists,
                goaltenderGoals: $scope.goaltenderGoals,
                goaltenderSaves: $scope.goaltenderSaves
            };

            console.log(data);

            $http.post("/post/poolConfig", data).then((res) => {
               console.log(res);
            }).catch((err) => {
                console.log("ERROR:");
                console.log(err);
            });
        };

    });