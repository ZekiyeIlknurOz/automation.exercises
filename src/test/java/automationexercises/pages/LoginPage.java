package automationexercises.pages;

import automationexercises.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[@data-qa='signup-name'] ")
    public WebElement name;
    @FindBy (xpath = "(//*[@name='email'])[2]")
    public WebElement newEmail;
    @FindBy (xpath = "//button[text()='Signup']")
    public WebElement signUp;
    @FindBy (xpath =  "//*[.='New User Signup!']")
    public WebElement newUserText;

    @FindBy (xpath = "//*[text()='Login to your account']")
    public WebElement loginToText;

    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement loginMail;

    @FindBy(xpath = "//*[@data-qa='login-password']")
    public WebElement password;

    @FindBy(xpath = "//*[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy (xpath = "//*[text()='Your email or password is incorrect!']")
    public WebElement incorrectError;

    @FindBy(xpath = "//*[.='Email Address already exist!']")
    public WebElement alreadyExistMail;


}