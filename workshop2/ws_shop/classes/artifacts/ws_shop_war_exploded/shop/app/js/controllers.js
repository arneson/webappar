'use strict';

/*
 * Controllers
 */

var productCatalogueControllers = angular.module('ProductCatalogueControllers', []);

productCatalogueControllers.controller('ProductListCtrl', ['$scope', 'ProductRegProxy',
    function($scope, ProductsRegProxy) {
        $scope.orderProp = 'id';
        $scope.pageSize = '10';
        $scope.currentPage = 0;
        ProductsRegProxy.count()
            .success(function(count) {
                $scope.count = count.value;
            }).error(function() {
            console.log("count: error");
        });
        getRange();
        $scope.$watch('currentPage', function() {
            getRange();
        });
        function getRange() {
            var fst = $scope.pageSize * $scope.currentPage;
            ProductsRegProxy.findRange(fst, $scope.pageSize)
                .success(function(Products) {
                    $scope.products = Products;
                }).error(function() {
                console.log("findRange: error");
            });
        }
    }]);

productCatalogueControllers.controller('ProductDetailCtrl', ['$scope',
    '$location', '$routeParams', 'ProductRegProxy',
    function($scope, $location, $routeParams, ProductRegProxy) {
        ProductRegProxy.find($routeParams.id)
            .success(function(product) {
                $scope.product = product;
            }).error(function() {
            console.log("selectByPk: error");
        });

        $scope.update = function() {
            ProductRegProxy.update($routeParams.id, $scope.product)
                .success(function() {
                    $location.path('/products');
                }).error(function() {
                ; // TODO;
            });
        };
        // A listener
        $scope.delete = function() {
            ProductRegProxy.delete($routeParams.id)
                .success(function() {
                    $location.path('/products');
                }).error(function() {
                ; // TODO;
            });
        };
    }]);


productCatalogueControllers.controller('ProductNewCtrl', ['$scope',
    '$location', 'ProductRegProxy',
    function($scope, $location, ProductRegProxy) {
        $scope.save = function() {
            ProductRegProxy.create($scope.product)
                .success(function() {
                    $location.path('/products');
                }).error(function() {
                ; // TODO;
            });
        };
    }]);


// General navigation controller
productCatalogueControllers.controller('NavigationCtrl', ['$scope', '$location',
    function($scope, $location) {
        $scope.navigate = function(url) {
            $location.path(url);
        };
    }]);


    // TODO more controllers if needed