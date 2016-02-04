*** REST Shop ***

Application
-----------
This is the "service based" (single page) approach. 
The shop model is RESTified using JAX-RS (backend) and AngularJS (frontend)
Most interaction use AJAX.

GlassFish
--------
This is run on GlassFish > 4.1

Frontend 
----------
Little skeleton code for front end (i.e. application not working).
See samples rest_angular_frontend how to do it.

Backend
-------
Backend code is there and possible to run

MVC
----
Handled by Angular (view, control), backend is just a "resource"
(wrapping the model)

Authentication
-----------------------------
None, add OAuth if you like

Testing
-------
See Test Packages curl_test.txt
See also code samples for using Jasmine testing on client side

Error handling
----------
Some in web.xml, some in code

Auth-entication and-orization
-----------------------------
None

Clean URL
---------
Should be designed when resources defined

Pagination
---------
Should be handled by Angular 

Resources
---------
All in folder resources

Front end dependencies
---------------------
This uses Bower for jquery, angular and bootstrap see resources/bower_components