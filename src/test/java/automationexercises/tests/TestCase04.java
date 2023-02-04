package automationexercises.tests;

import automationexercises.pages.HomePage;
import automationexercises.pages.LoginPage;
import automationexercises.utilities.ConfigReader;
import automationexercises.utilities.Driver;
import automationexercises.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase04 {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void logoutUserSuccesfull() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.body.isDisplayed());

        //4. Click on 'Signup / Login' button
        homePage.signUpLogin.click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(loginPage.loginToText.isDisplayed());

        //6. Enter correct email address and password
        loginPage.loginMail.sendKeys(ConfigReader.getProperty("mail"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));

        //7. Click 'login' button
        loginPage.loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePage.loggedIn.isDisplayed());

        //9. Click 'Logout' button
        homePage.logOut.click();

        //10. Verify that user is navigated to login page
        Assert.assertTrue(loginPage.loginToText.isDisplayed());
    }
}
