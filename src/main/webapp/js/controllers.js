'use strict';

/* Controllers */

var itsBurningControllers = angular.module('itsBurning.controllers', []);

itsBurningControllers.controller('ProductListCrtl', ['$scope', 'Product',
  function($scope, Product) {
    $scope.products = Product.query();
  }]);

itsBurningControllers.controller('MyCtrl2', [function() {
}]);

itsBurningControllers.controller('NavCtrl', ['$scope', '$route',
    function($scope, $route) {
      $scope.isActive = function(tab) {
        if($route.current != null)
          return tab === $route.current.activetab;
      }
}]);