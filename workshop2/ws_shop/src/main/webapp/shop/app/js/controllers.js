'use strict';

/*
 * Controllers
 */

var productCatalogueControllers = angular.module('ProductCatalogueControllers', []);

productCatalogueControllers.controller('ProductListCtrl', ['$scope', 'ProductCatalogueProxy',
    function($scope, ProductsCatalogueProxy) {
        $scope.orderProp = 'id';
        $scope.pageSize = '10';
        $scope.currentPage = 0;
        ProductsCatalogueProxy.count()
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
            ProductsCatalogueProxy.findRange(fst, $scope.pageSize)
                .success(function(Products) {
                    $scope.products = Products;
                }).error(function() {
                console.log("findRange: error");
            });
        }
    }]);

productCatalogueControllers.controller('ProductDetailCtrl', ['$scope',
    '$location', '$routeParams', 'ProductCatalogueProxy',
    function($scope, $location, $routeParams, ProductCatalogueProxy) {
        ProductCatalogueProxy.find($routeParams.id)
            .success(function(product) {
                $scope.product = product;
            }).error(function() {
            console.log("selectByPk: error");
        });

        $scope.update = function() {
            ProductCatalogueProxy.update($routeParams.id, $scope.product)
                .success(function() {
                    $location.path('/products');
                }).error(function() {
                console.log('update failed');
            });
        };
        // A listener
        $scope.delete = function() {
            ProductCatalogueProxy.delete($routeParams.id)
                .success(function() {
                    $location.path('/products');
                }).error(function() {
                console.log('deletion failed');
            });
        };
    }]);


productCatalogueControllers.controller('ProductNewCtrl', ['$scope',
    '$location', 'ProductCatalogueProxy',
    function($scope, $location, ProductCatalogueProxy) {
        $scope.save = function() {
            ProductCatalogueProxy.create($scope.product)
                .success(function() {
                    $location.path('/products');
                }).error(function() {
                console.log('save failed');
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
