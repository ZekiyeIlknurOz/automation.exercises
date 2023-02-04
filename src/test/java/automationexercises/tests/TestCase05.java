package automationexercises.tests;

import automationexercises.pages.HomePage;
import automationexercises.pages.LoginPage;
import automationexercises.pages.SignUpPage;
import automationexercises.utilities.ConfigReader;
import automationexercises.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase05 {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();


    @Test
    public void registerUser() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.body.isDisplayed());

        //4. Click on 'Signup / Login' button
        homePage.signUpLogin.click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(loginPage.newUserText.isDisplayed());

        //6. Enter name and already registered email address
        loginPage.name.sendKeys(ConfigReader.getProperty("name"));
        loginPage.newEmail.sendKeys(ConfigReader.getProperty("kayitlimail"));

        //7. Click 'Signup' button
        loginPage.signUp.click();

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(loginPage.alreadyExistMail.isDisplayed());
    }
}
