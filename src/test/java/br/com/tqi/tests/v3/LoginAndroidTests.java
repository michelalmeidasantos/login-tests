package br.com.tqi.tests.v3;

import br.com.tqi.tests.v3.constants.Constants;
import br.com.tqi.tests.v3.driver.DriverManager;
import br.com.tqi.tests.v3.pages.HomePage;
import br.com.tqi.tests.v3.pages.LoginPage;
import br.com.tqi.tests.v3.pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginAndroidTests {

    LoginPage loginPage = new LoginPage(DriverManager.start());
    RegisterPage registerPage = new RegisterPage(DriverManager.start());
    HomePage homePage = new HomePage(DriverManager.start());

    @AfterEach
    void shutDown() {
        DriverManager.stop();
    }

    @Test
    void logarAposCriarUsuario() {
        loginPage.registerButton.click();
        registerPage.nameInput.sendKeys(Constants.NAME);
        registerPage.emailInput.sendKeys(Constants.EMAIL);
        registerPage.passwordInput.sendKeys(Constants.PASSWORD);
        registerPage.finishRegisterButton.click();
        loginPage.emailInput.sendKeys(Constants.EMAIL);
        loginPage.passwordInput.sendKeys(Constants.PASSWORD);
        loginPage.loginButton.click();
        Assertions.assertEquals(Constants.EMAIL, homePage.homeUserEmail.getText());
    }
}
