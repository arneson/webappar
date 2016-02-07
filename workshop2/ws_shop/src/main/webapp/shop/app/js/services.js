'use strict';

/* Services */

var productCatalogueService = angular.module('ProductCatalogueService', []);

// Representing the remote RESTful ProductCatalogue
productCatalogueService.factory('ProductCatalogueProxy', ['$http',
    function($http) {

        var url = 'http://localhost:8080/ws_shop-1.0-SNAPSHOT/webresources/products';

        return {
            find: function (id){
                return $http.get(url + "/" + id);
            },
            findAll: function (){
                return $http.get(url);
            },
            delete: function (id){
                return $http.delete(url + "/" + id);
            },
            create: function (product){
                return $http.post(url, product); //Look into forms
            },
            update: function (id, product){
                return $http.put(url + "/" + id, product);
            },
            findRange: function(first, count){
                return $http.get(url + "/range?fst=" + first + "&max=" + count);
            },
            count: function(){
                return $http.get(url + "/count");
            }
        };
    }]);

