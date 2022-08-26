package br.com.tqi.tests.v3.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public DriverManager() {
    }

    static AppiumDriver<WebElement> driver;
//    static AppiumDriver driver; //se appium client >= 8 não tem generic <>

    public static AppiumDriver<WebElement> start() {
//    public static AppiumDriver<WebElement> start() { //se appium client >= 8 não tem generic <>
        if (driver == null) {
            AppiumDriverLocalService service;
            service = new AppiumServiceBuilder()
                    .withIPAddress("0.0.0.0")
                    .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub") //necesário se appium client > 8 e appium server = 1
                    .build();
            service.start();

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("deviceName", "emulator-5554");
            desiredCapabilities.setCapability("automationName", "uiautomator2");

//        // forma 1 de abrir apk, para pegar appPackage e appActivity rodar no terminal: adb shell "dumpsys window | grep mCurrentFocus"
//        desiredCapabilities.setCapability("appPackage", "com.tqi.login");
//        desiredCapabilities.setCapability("appActivity", "com.tqi.login.activity.LoginActivity");

//        //forma 2 de abrir apk
            desiredCapabilities.setCapability("app", new File("src/test/resources/app/login.apk").getAbsolutePath());
            desiredCapabilities.setCapability("fullReset", "true");
            desiredCapabilities.setCapability("noReset", "false");

//        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities); // se appium client <= 7 tem /wd/hub
            driver = new AppiumDriver<>(service.getUrl(), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

////        // Se appium client > 8, não use DesiredCapabilities, utilize UiAutomator2Options e Duration.ofSeconds:
//        UiAutomator2Options options = new UiAutomator2Options()
//                .setDeviceName("emulator-5554")
//                .setPlatformName("Android")
////        //forma 1 de abrir apk
//                .setAppPackage("com.tqi.login")
//                .setAppActivity("com.tqi.login.activity.LoginActivity")
////        //forma 2 de abrir apk
////                .setApp("src/test/resources/app/login.apk")
////                .setFullReset(true)
////                .setNoReset(false)
//                .eventTimings();
////        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723"), desiredCapabilities); // se appium client >= 8 não tem /wd/hub
//        driver = new AndroidDriver(service.getUrl(), options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
        } else
            return driver;
    }

    public static void stop() {
        driver.quit();
    }

}