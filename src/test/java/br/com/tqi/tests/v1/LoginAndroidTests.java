package br.com.tqi.tests.v1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginAndroidTests {

    @Test
    void logarAposCriarUsuario() throws MalformedURLException {
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

        AppiumDriver<WebElement> driver;
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
//        AppiumDriver driver; // se appium client >= 8 não tem generics <>
////        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723"), desiredCapabilities); // se appium client >= 8 não tem /wd/hub
//        driver = new AndroidDriver(service.getUrl(), options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("com.tqi.login:id/textViewLinkRegister")).click();
        driver.findElement(By.id("com.tqi.login:id/textInputEditTextName")).sendKeys("teste");
        driver.findElement(By.id("com.tqi.login:id/textInputEditTextEmail")).sendKeys("teste@teste.com");
        driver.findElement(By.id("com.tqi.login:id/textInputEditTextPassword")).sendKeys("123456");
        driver.findElement(By.id("com.tqi.login:id/buttonRegister")).click();
        driver.findElement(By.id("com.tqi.login:id/textInputEditTextEmail")).sendKeys("teste@teste.com");
        driver.findElement(By.id("com.tqi.login:id/textInputEditTextPassword")).sendKeys("123456");
        driver.findElement(By.id("com.tqi.login:id/buttonLogin")).click();
        Assertions.assertEquals("teste@teste.com", driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")).getText());

        driver.quit();
    }

}
