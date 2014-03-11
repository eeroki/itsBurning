'use strict';


// Declare app level module which depends on filters, and services
angular.module('itsBurning', [
  'ngRoute',
  'itsBurning.filters',
  'itsBurning.services',
  'itsBurning.directives',
  'itsBurning.controllers'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {templateUrl: 'partials/product-list.html', controller: 'ProductListCrtl'});
  $routeProvider.when('/view2', {templateUrl: 'partials/partial2.html', controller: 'MyCtrl2'});
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
