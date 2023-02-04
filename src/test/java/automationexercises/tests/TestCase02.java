package automationexercises.tests;

import automationexercises.pages.AccountCreatedOrDeleted;
import automationexercises.pages.HomePage;
import automationexercises.pages.LoginPage;
import automationexercises.utilities.ConfigReader;
import automationexercises.utilities.Driver;
import automationexercises.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountCreatedOrDeleted accountCreatedOrDeleted = new AccountCreatedOrDeleted();

    @Test (priority = -1)
    public void testName() {
        //1. Create an Account
        ReusableMethods.createAnAccount();
        Driver.closeDriver();
    }

    @Test
    public void loginUserSuccesfull() {
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
        loginPage.loginMail.sendKeys(ConfigReader.getProperty("abhsycd"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));

        //7. Click 'login' button
        loginPage.loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePage.loggedIn.isDisplayed());

        //9. Click 'Delete Account' button
        homePage.deleteAccount.click();
        ReusableMethods.navigateBack();
        homePage.deleteAccount.click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(accountCreatedOrDeleted.accountDeletedMsg.isDisplayed());

    }
}