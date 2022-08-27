package br.com.tqi.tests.v3.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public DriverManager() {
    }

    static AppiumDriver<WebElement> driver;
    static AppiumDriverLocalService service;

    public static AppiumDriver<WebElement> start() {
        if (driver == null) {
            service = new AppiumServiceBuilder()
                    .withIPAddress("0.0.0.0")
                    .usingAnyFreePort()
                    .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
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

            driver = new AppiumDriver<>(service.getUrl(), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            return driver;
        } else
            return driver;
    }

    public static void stop() {
        driver.quit();
        service.stop();
    }

}