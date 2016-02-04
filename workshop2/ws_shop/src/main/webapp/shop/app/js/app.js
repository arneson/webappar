'use strict';

/* 
 *  The Shop App
 */
var shop = angular.module('Shop', [
    'ngRoute'
            // More here
]);


shop.config(['$routeProvider',
    function ($routeProvider) {  // Injected object $routeProvider
        $routeProvider.
                when('/products', {
                    templateUrl: 'partials/products/products.html',
                    controller: 'PersonListCtrl'
                }).
                when('/products/:id', {
                    templateUrl: 'partials/products/product-detail.html',
                    controller: 'ProductDetailCtrl'
                }).
                when('/product', {
                    templateUrl: 'partials/products/product-new.html',
                    controller: 'ProductNewCtrl'
                }).
                otherwise({
                    redirectTo: '/products'
                });
                
                // TODO Add more navigation
                

    }]);


