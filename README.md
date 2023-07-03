# Appium_EMI_Calculator_Automation

### An EMI calculator is automated by testing with varities of datasets and whether it gives correct results with correct data.Appium is utilized on an emulated device powered by Android Studio.

Here the following tasks are done:

* An EMI Calculator app extracted from [EMI calculator](https://play.google.com/store/apps/details?id=com.continuum.emi.calculator&hl=en&gl=US) is automated by extracting its apk.
* Basic operations like add,subtract,multiplication and divide functionality is checked whether it is giving correct result or not using Appium.
* The monthly EMI,total interest ,processing fee and total payment generated are matched with the expected data provided in the dataset.
* Different data is tested where user gives Amount,Interest,Period and Processing fee and hits Calculate button.
* It is tested for five different data and a reset button will be pressed after a test case with a single data is executed.

### Technology:
* Tool: Selenium Webdriver
* IDE: Intellij, Android Studio
* Build tool: Gradle
* Language: Java
* Test_Runner: Appium

### Prerequisites:
* Install Android Studio latest version
* Install Appium 1.17.1
* Install jdk 8 or any LTS version
* Configure ANDROID_HOME, JAVA_HOME and GRADLE_HOME
* Stable internet connection

### Project Run
#### Appium
* Turn on Developer Options on your android phone
* Connect your android phone with USB cable/ Create an emulated virtual device via Android Studio and run it.
* Open cmd and give adb devices command to get uuid.
* Open Appium and start server. Then open inspector tool.
* In the JSON Representation section, paste the following desired capabilities after adding your uuid and version:


```bash
  "deviceName": "My Device",
  "platformName": "Android",
  "uuid": Enter your uuid here,
  "platformVersion": Enter your android version,
  "appPackage": "com.continuum.emi.calculatorr",
  "appActivity": "com.finance.emicalci.activity.Splash_screnn"
```

### Run the Automation Script by the following command:
```bash
  gradle clean test
```
### Test Summary
![EMI_Test_Summary](https://github.com/AbirHossenMunna/Appium_EMI_Calculator_Automation/assets/59090637/b6cfe20d-7228-431c-bad1-ef63578ba5a9)

### After automation to view allure report , give the following commands:
```bash
  allure generate allure-results --clean -o allure-report
  allure serve allure-results
```
### Report
![EMI_Test_Suites](https://github.com/AbirHossenMunna/Appium_EMI_Calculator_Automation/assets/59090637/adfea4ae-9ac8-406d-8728-120ff6aa42da)

