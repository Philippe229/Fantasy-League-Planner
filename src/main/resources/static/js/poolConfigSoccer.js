'use strict';

angular.module('app')
    .controller('poolConfigControllerSoccer', function ($scope, $http) {

        $scope.setConfig = function () {
            let data = {
                attackerAssists: $scope.attackerAssists,
                attackerGoals: $scope.attackerGoals,
                midfielderAssists: $scope.midfielderAssists,
                midfielderGoals: $scope.midfielderGoals,
                defenderAssists: $scope.defenderAssists,
                defenderGoals: $scope.defenderGoals,
            };

            console.log(data);

            $http.post("/post/poolConfigSoccer", data).then((res) => {
                console.log(res.data);
                $scope.playersMap = res.data;
            }).catch((err) => {
                console.log("ERROR:");
                console.log(err);
            });
        };

    });