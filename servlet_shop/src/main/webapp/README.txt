*** Servlet shop ***

Tomcat
--------
This is run on Tomcat using "deploy on save" to speed
up development cycle.
If using Tomcat and too much logging edit file
.netbeans/8.0/apache-tomcat-8.0.3.0_base/conf/logging.properties
(or global logging.properties) Edit like (change FINE to OFF)
1catalina.org.apache.juli.AsyncFileHandler.level = OFF
(consoleHanlder possibly not OFF, better INFO)

Application
-----------
This is the "request based" approach. The shop model
is "webbified" using Servlets and Java Server pages.
Application interacting directly with low level HTTP concepts 
(request, response, params, sessions, ...)

Lots of relative URI's with leading ${pageContext.request.contextPath}
(to get application root, same as leading "/") 
Else confusing combinations of URIs occur (relative URIs combined with actual URI)

Most of application "hidden" in WEB-INF i.e. not accessible
using URIs in browser (must go through application)

MVC
----
All calls go through the Router (a JEE WebFilter), filtering out 
resources, start page (home) and different parts of 
application (Products, Orders ,...)
Servlets are controls and JSP pages are the view
(and shop is the model, note Maven dependency)

GUI View
---------
Using a template (jsp) for overall style and partials
for dynamic content (jsp's)
Bootstrap library for component styles (and a few own rules in default.css) 
(NOTE: Deleted /*# sourceMappingURL=bootstrap.css.map */ (last line in bootstrap.css)
to avoid call for css.map)

Some simple JavaScript for navigation back (histori API)

Initialization
---------------
A reference to the shop is stored in the ApplicationScope at
application startup (using a web listener).
At session start some global session variables set.

Error handling
----------
Some in web.xml some in code

Auth-entication and -orization
-----------------------------
None

Clean URL
---------
URL:s hard coded in application, nice look but not very customizable

Pagination
---------
Hardcoded to 5 items/page

Resources
---------
All in folder resources


