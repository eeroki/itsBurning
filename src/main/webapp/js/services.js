'use strict';

/* Services */



var productServices = angular.module('itsBurning.services', ['ngResource']);

productServices.factory('Product', ['$resource',
  function($resource){
    return $resource('products/:id', {}, {
      query: {method: 'GET', params:{productId: 'products'}, isArray: true}
    });
  }]);
