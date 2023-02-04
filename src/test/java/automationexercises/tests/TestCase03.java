package automationexercises.tests;

import automationexercises.pages.HomePage;
import automationexercises.pages.LoginPage;
import automationexercises.utilities.ConfigReader;
import automationexercises.utilities.Driver;
import automationexercises.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase03 {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void incorrectMail() {


        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //4. Click on 'Signup / Login' button
        homePage.signUpLogin.click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(loginPage.loginToText.isDisplayed());

        //6. Enter incorrect email address and password
        loginPage.loginMail.sendKeys(Faker.instance().internet().emailAddress());
        loginPage.password.sendKeys(Faker.instance().internet().password());

        //7. Click 'login' button
        loginPage.loginButton.click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        ReusableMethods.verifyElementDisplayed(loginPage.incorrectError);
        Driver.closeDriver();

    }
}
