# DPS UI Automated Tests 
> THOR DPS UI Scenarios on Selenium Grid and Saucelabs (Mobile & Desktop)

## How to

### Execute Tests in Local
#### 1. Maven Execution (Command-line or Intellij Terminal) : 
This is recommended for a handful of features to mimic the pipeline execution on your local machine.

 - Control the `dataproviderthreadcount` in **pom.xml** against the -profile ***local*** to the desired value (To control the parallel execution)
 - Open Command-line or Terminal (Intellij)
 - `mvn clean test -P local -Denv=(local|dev|qa1) -Dcucumber.filter.tags="@thor" allure:report`
 - Allure report will be generated in ```target/allure-results/html```

#### 2. IntelliJ Execution :
This is recommended for debug or less scenarios during dry run

 - Create a new ***TestNG*** Run configuration in intelliJ
 - In the ***configuration*** tab, select the ***Test Kind*** as **Suite**
 - Add the .xml from .`./../cep_dps_front-end_application_tests_java/config/local-config.xml`
 - In VM Options parse the env and tags `-Denv=dev -Dcucumber.filter.tags="@thor"` (Other params can also be parsed here including `allure:report` etc)
 - The scenario(s) can be run or debug using this option

**Note:**
Only a single option is meant to be selected for **-Denv** argument, for example -**Denv=dev**. If running locally, also add **-Dport=3000**. If you want to test in test4, then use -Denv=qa1 -Dexternal 

### Execute Tests in Pipeline
`mvn clean test -P functional-test-dev -Denv=dev -Dcucumber.filter.tags="@thor"` will execute the tests and generate the allure report. 

### Generating a report
run the command ```mvn allure:report```, the html report will be generated in ```target/allure-results/html``` and it is named 'index.html'

### To run the DataLayerReport
run the command ```mvn test exec:java```, the html report will be generated in ```datalayer-report/html/html``` and it is named 'index.html'
