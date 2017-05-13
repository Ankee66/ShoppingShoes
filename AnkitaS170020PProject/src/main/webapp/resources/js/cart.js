
var app = angular.module('myCart', []);
app.controller('myCtrl', function($scope, $http) {
    $http.get("/bhoomi_webapp_01/cart/cart/get")
    .then(function(response) {
        $scope.names = response.data;
    });
    $scope.orderByMe = function(x) {
        $scope.myOrderBy = x;
    }
});