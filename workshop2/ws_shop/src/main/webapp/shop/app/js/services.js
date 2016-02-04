'use strict';

/* Services */

var productCatalogueService = angular.module('ProductCatalogueService', []);

// Representing the remote RESTful ProductCatalogue
productCatalogueService.factory('ProductCatalogueProxy', ['$http',
    function($http) {

        var url = 'TODO';

  
        return {
            
            // TODO Add methods to call backend resource class (using AJAX) 
          
        };
    }]);

