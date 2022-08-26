package br.com.tqi.tests.v5.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    AppiumDriver driver; // appium client >= 8 não tem generic<>

    public RegisterPage(AppiumDriver driver) { // appium client >= 8 não tem generic<>
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.tqi.login:id/textInputEditTextName")
    public WebElement nameInput;

    @AndroidFindBy(id = "com.tqi.login:id/textInputEditTextEmail")
    public WebElement emailInput;

    @AndroidFindBy(id = "com.tqi.login:id/textInputEditTextPassword")
    public WebElement passwordInput;

    @AndroidFindBy(id = "com.tqi.login:id/buttonRegister")
    public WebElement finishRegisterButton;

}
