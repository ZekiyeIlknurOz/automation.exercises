package automationexercises.utilities;

import automationexercises.pages.HomePage;
import automationexercises.pages.LoginPage;
import automationexercises.pages.SignUpPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertTrue;

public class ReusableMethods {
    static SignUpPage signUpPage = new SignUpPage();
    static Select select;
    static Faker faker = new Faker();
    static HomePage homePage = new HomePage();
    static LoginPage loginPage = new LoginPage();

    public static void clickByJS(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", element);
    }

    public static void navigateBack() {
        Driver.getDriver().navigate().back();
    }

    public static void createAnAccount() {
        Driver.getDriver().get("https://automationexercise.com/login");
        homePage.signUpLogin.click();
        loginPage.name.sendKeys(ConfigReader.getProperty("name"));
        loginPage.name.sendKeys(Faker.instance().internet().emailAddress());
        loginPage.newEmail.sendKeys(ConfigReader.getProperty("mail"));
        loginPage.signUp.click();
        signUpPage.cinsiyet.click();
        signUpPage.password.sendKeys(ConfigReader.getProperty("password"));
        signUpPage.day.sendKeys("4");
        signUpPage.month.sendKeys("May");
        signUpPage.year.sendKeys("1976");
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

    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + element);
        }
    }

}
