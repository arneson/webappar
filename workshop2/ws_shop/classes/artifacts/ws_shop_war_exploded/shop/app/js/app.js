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
                }); 
                
                // TODO Add more navigation
                

    }]);


