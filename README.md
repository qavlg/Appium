# Android(app) automation test-cases for the [Orthodox Calendar](https://apkpure.com/ru/%D0%BF%D1%80%D0%B0%D0%B2%D0%BE%D1%81%D0%BB%D0%B0%D0%B2%D0%BD%D1%8B%D0%B9-%D0%BA%D0%B0%D0%BB%D0%B5%D0%BD%D0%B4%D0%B0%D1%80%D1%8C/com.neosphere.ocalendar/download?ysclid=m4tkdpspbq461349632)

These test-cases checks the IntroScreen and DetailedScreen.
There are six tests in this project.

The project uses 21 Java version.

In order to run the ALL tests is necessary input a command into the terminal:
- **./mvnw clean test**  OR **mvn clean test**

In order to run one of the test's class(such tests for the screens as the Intro screen, Detailed screen) is necessary input a command into the terminal:
- **./mvnw clean test -Dtest=<Input the name of the test's class>** 

  For instance: **./mvnw clean test -Dtest=IntroScreen**

In order to run Allure is necessary input a command into the terminal:
- **./mvnw allure:serve** OR **mvn allure:serve**
  

