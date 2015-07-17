# webdriver-java
Sample framework with webdriver (java), run using gradle

# Why?

The intention of this project is multi-fold:

* ability to provide custom annotations in unit - for easier test categorization.
> See the DemoTest / OneMoreTest as examples how to specify custom annotations for test categorization
* ability to run specific test category tests - as specified from command-line (and hence, also from CI)
* do assertions based on actual performance with expected - This work is still in progress
> in this case, it really means the time taken to execute the test

# How to use

To run tests: 
> gradle clean runTests

To run tests having specific test annotation: 
> gradle clean runTests -Ponly=foo

# Reports
Test run reports will be available in 
> ./build/reports/tests/index.html
