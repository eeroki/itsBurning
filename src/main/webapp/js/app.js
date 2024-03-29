'use strict';


// Declare app level module which depends on filters, and services
angular.module('itsBurning', [
  'ngRoute',
  'ui.bootstrap',
  'itsBurning.filters',
  'itsBurning.services',
  'itsBurning.directives',
  'itsBurning.controllers'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'partials/product-list.html',
    controller: 'ProductListCrtl',
    activetab: 'home'
  });
  $routeProvider.when('/view2', {
    templateUrl: 'partials/partial2.html',
    controller: 'MyCtrl2',
    activetab: 'details'
  });
  $routeProvider.when('/products/:id', {
    templateUrl: 'partials/product-details.html',
    controller: 'ProductDetailCrtl'
  });
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
