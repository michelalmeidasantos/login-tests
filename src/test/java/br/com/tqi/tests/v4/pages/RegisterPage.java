package br.com.tqi.tests.v4.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    AppiumDriver<WebElement> driver;

    public RegisterPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.tqi.login:id/textInputEditTextName")
    public MobileElement nameInput;

    @AndroidFindBy(id = "com.tqi.login:id/textInputEditTextEmail")
    public MobileElement emailInput;

    @AndroidFindBy(id = "com.tqi.login:id/textInputEditTextPassword")
    public MobileElement passwordInput;

    @AndroidFindBy(id = "com.tqi.login:id/buttonRegister")
    public MobileElement finishRegisterButton;

}
