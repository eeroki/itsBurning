'use strict';

/* Controllers */

var itsBurningControllers = angular.module('itsBurning.controllers', []);

itsBurningControllers.controller('ProductListCrtl', ['$scope', 'Product',
  function($scope, Product) {
    $scope.products = Product.query();
  }]);

itsBurningControllers.controller('MyCtrl2', [function() {
}]);