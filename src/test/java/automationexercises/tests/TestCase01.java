package automationexercises.tests;

import automationexercises.pages.AccountCreatedOrDeleted;
import automationexercises.pages.HomePage;
import automationexercises.pages.LoginPage;
import automationexercises.pages.SignUpPage;
import automationexercises.utilities.ConfigReader;
import automationexercises.utilities.Driver;
import automationexercises.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();
    AccountCreatedOrDeleted accountCreatedOrDeleted = new AccountCreatedOrDeleted();
    Faker faker = new Faker();
    Select select;
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

        //6. Enter name and email address
        loginPage.name.sendKeys(ConfigReader.getProperty("name"));
        loginPage.newEmail.sendKeys(ConfigReader.getProperty("mail"));

        //7. Click 'Signup' button
        loginPage.signUp.click();

        
        //8. Fill All details and Click 'Create Account button'
        createAccount();
        //9. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(accountCreatedOrDeleted.accountCreateMsg.isDisplayed());
        //10. Click 'Continue' button
        accountCreatedOrDeleted.continueButton.click();
        Driver.getDriver().navigate().back();
        accountCreatedOrDeleted.continueButton.click();
        //. Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePage.loggedIn.isDisplayed());
        //. Click 'Delete Account' button
        homePage.deleteAccount.click();
        //. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(accountCreatedOrDeleted.accountDeletedMsg.isDisplayed());
        System.out.println("akdjffgit ");
        accountCreatedOrDeleted.continueButton.click();
    }
    public void createAccount(){
        signUpPage.cinsiyet.click();
        signUpPage.password.sendKeys(ConfigReader.getProperty("password"));
        signUpPage.day.sendKeys("7");
        signUpPage.month.sendKeys("May");
        signUpPage.year.sendKeys("1991");
        signUpPage.firstName.sendKeys(ConfigReader.getProperty("name"));
        signUpPage.lastName.sendKeys(faker.name().lastName());
        signUpPage.address1.sendKeys(faker.address().fullAddress());
        select = new Select(signUpPage.country);
        select.selectByIndex(2);
        signUpPage.state.sendKeys(faker.address().state());
        signUpPage.city.sendKeys(faker.address().city());
        signUpPage.zipcode.sendKeys(faker.address().zipCode());
        signUpPage.mobileNumber.sendKeys(faker.phoneNumber().phoneNumber());
        ReusableMethods.clickByJS(signUpPage.createAccount);
    }


}


