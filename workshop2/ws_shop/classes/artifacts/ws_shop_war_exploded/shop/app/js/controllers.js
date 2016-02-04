'use strict';

/*
 * Controllers
 */

var productCatalogueControllers = angular.module('ProductCatalogueControllers', []);

// General navigation controller
productCatalogueControllers.controller('NavigationCtrl', ['$scope', '$location',
    function($scope, $location) {
        $scope.navigate = function(url) {
            $location.path(url);
        };
    }]);


    // TODO more controllers if needed