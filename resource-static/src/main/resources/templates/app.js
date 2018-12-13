var app = angular.module('BlankApp', ['ngMaterial', 'ngMessages']);

app.controller('MainCtrl', function($scope, $timeout) {
  $scope.loginModel = {
    username: '',
    password: ''
  };

});