package br.com.tqi.tests.v4.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public DriverManager() {
    }

    static AppiumDriver<WebElement> driver;
//    static AppiumDriver driver; //se appium client >= 8 não tem generic <>
    public static String userName = "michelsantos4";
    public static String accessKey = "L5x7uNxH64tMLVpyqn8y";

    public static AppiumDriver<WebElement> start() throws MalformedURLException {
//    public static AppiumDriver start() throws MalformedURLException { // appium cliente >= 8 não tem generic <>
        if (driver == null) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("device", "Samsung Galaxy Tab S7");
            caps.setCapability("app", "bs://04fe3755c09aeb8542a9c4455d2d9efd191a8c18");
            caps.setCapability("os_version", "10.0");

            driver = new AppiumDriver<>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//            // appium client >= 8 não usa DesiredCapabilities, utilizar UiAutomator2Options e Duration.ofSeconds:
//            UiAutomator2Options options = new UiAutomator2Options()
//                    .setApp("bs://04fe3755c09aeb8542a9c4455d2d9efd191a8c18")
//                    .setDeviceName("Samsung Galaxy Tab S7")
//                    .setPlatformVersion("10.0")
//                    .eventTimings();
//
//            driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), options);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            return driver;
        } else
            return driver;
    }

    public static void stop() {
        driver.quit();
    }

}