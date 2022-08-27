package br.com.tqi.tests.v4.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public DriverManager() {
    }

    static AppiumDriver<WebElement> driver;
    public static String userName = "michelsantos4";
    public static String accessKey = "L5x7uNxH64tMLVpyqn8y";

    public static AppiumDriver<WebElement> start() throws MalformedURLException {
        if (driver == null) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("device", "Samsung Galaxy S20");
            caps.setCapability("app", "bs://04fe3755c09aeb8542a9c4455d2d9efd191a8c18");

            driver = new AppiumDriver<>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            return driver;
        } else
            return driver;
    }

    public static void stop() {
        driver.quit();
    }

}