package br.com.tqi.tests.v5.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;

public class DriverManager {
    public DriverManager() {
    }

    static AppiumDriver driver; // appium client >= 8 não tem generic <>
    static AppiumDriverLocalService service;

    public static AppiumDriver start() { // appium client >= 8 não tem generic <>
        if (driver == null) {
            service = new AppiumServiceBuilder()
                    .withIPAddress("0.0.0.0")
                    .usingAnyFreePort()
                    .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                    .build();
            service.start();

//        UiAutomator2Options options = new UiAutomator2Options() // UiAutomator2Options não existe em appium client < 8
//                .setDeviceName("emulator-5554")
//                .setPlatformName("Android")
////        //forma 1 de abrir apk
////                .setAppPackage("com.tqi.login")
////                .setAppActivity("com.tqi.login.activity.LoginActivity")
////        //forma 2 de abrir apk
//                .setApp("src/test/resources/app/login.apk")
//                .setFullReset(true)
//                .setNoReset(false)
//                .eventTimings();
//        driver = new AndroidDriver(service.getUrl(), options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
        } else
            return driver;
    }

    public static void stop() {
        driver.quit();
        service.stop();
    }

}