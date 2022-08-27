package br.com.tqi.tests.v2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginAndroidTests {

    public static final String NAME = "teste";
    public static final String EMAIL = "teste@teste.com";
    public static final String PASSWORD = "123456";

    AppiumDriver<WebElement> driver;
    AppiumDriverLocalService service;

    @BeforeEach
    void start() {
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

    }

    @AfterEach
    void stop() {
        driver.quit();
        service.stop();
    }

    @Test
    void logarAposCriarUsuario() {
        WebElement registerButton = driver.findElement(By.id("com.tqi.login:id/textViewLinkRegister"));
        registerButton.click();
        WebElement nameInput = driver.findElement(By.id("com.tqi.login:id/textInputEditTextName"));
        nameInput.sendKeys(NAME);
        WebElement emailInputRegister = driver.findElement(By.id("com.tqi.login:id/textInputEditTextEmail"));
        emailInputRegister.sendKeys(EMAIL);
        WebElement passwordInputRegister = driver.findElement(By.id("com.tqi.login:id/textInputEditTextPassword"));
        passwordInputRegister.sendKeys(PASSWORD);
        WebElement finishRegisterButton = driver.findElement(By.id("com.tqi.login:id/buttonRegister"));
        finishRegisterButton.click();
        WebElement emailInputLogin = driver.findElement(By.id("com.tqi.login:id/textInputEditTextEmail"));
        emailInputLogin.sendKeys(EMAIL);
        WebElement passwordInputLogin = driver.findElement(By.id("com.tqi.login:id/textInputEditTextPassword"));
        passwordInputLogin.sendKeys(PASSWORD);
        WebElement loginButton = driver.findElement(By.id("com.tqi.login:id/buttonLogin"));
        loginButton.click();
        WebElement homeUserEmail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]"));
        Assertions.assertEquals(EMAIL, homeUserEmail.getText());
    }

}
