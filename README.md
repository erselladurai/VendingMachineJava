# Vending Machine Automated Tests 
> Vending Machine test Scenarios on Maven

## How to

### Execute Tests in Local
#### 1. Maven Execution (Command-line or Intellij Terminal) : 
This is recommended for a handful of features to mimic the pipeline execution on your local machine.

  - Open Command-line or Terminal (Intellij)
 - `mvn clean test -P AllTests

#### 2. IntelliJ Execution :
 - Create a new ***JUnit*** Run configuration in intelliJ
 - In the ***configuration*** tab, select the ***Test Kind*** as **Package**
 - Enter the text **purchase** in the **Package** text box and click apply
 - - The scenario(s) can be run or debug using this option
