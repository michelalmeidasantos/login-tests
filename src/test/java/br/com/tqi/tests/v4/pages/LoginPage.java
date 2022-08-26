package br.com.tqi.tests.v4.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    AppiumDriver<WebElement> driver;

    public LoginPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.tqi.login:id/textViewLinkRegister")
    public WebElement registerButton;

    @AndroidFindBy(id = "com.tqi.login:id/textInputEditTextEmail")
    public WebElement emailInput;

    @AndroidFindBy(id = "com.tqi.login:id/textInputEditTextPassword")
    public WebElement passwordInput;

    @AndroidFindBy(id = "com.tqi.login:id/buttonLogin")
    public WebElement loginButton;

}
