# Vending Machine Automated Tests 
> Vending Machine test Scenarios on Maven

## How to

### Execute Tests in Local
#### 1. Maven Execution (Command-line or Intellij Terminal) : 
This is recommended for a handful of features to mimic the execution on your local machine.

  - Open Command-line or Terminal (Intellij)
 - `mvn clean test -P AllTests surefire-report:report
 -  A HTML report should be generated in ${basedir}/target/site/surefire-report.html.

#### 2. IntelliJ Execution :
 - Create a new ***JUnit*** Run configuration in intelliJ
 - Give some configuration name as your own.
 - In the ***configuration*** tab, select the ***Test Kind*** as **Package**
 - Enter the text **vending.machine.test** in the **Package** text box and click apply
 - - The scenario(s) can be run or debug using this option
 - Finally click on run button to run the junit unit tests with the configuration
 - Results can be viewed in the Console.
