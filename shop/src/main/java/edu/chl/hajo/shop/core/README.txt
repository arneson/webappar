*** The Shop model ***

Java 8 used!
- New Stream API pop's up

Dependency on Lombok (NOTE version Lombok 16 failed so go back to 14?)

This is an basic OO model of a (rather generic) web shop
- Application specific parts in core-package 
- Reusable parts in util-package.
- No defensive programming (validation) here, handled later.
- No sorting of results, handled by database later
- Model objects are as immutable as possible for now ...
- ... sadly we will have to change this (JEE does not accept immutability)
- There are some simple tests see Test Packages

