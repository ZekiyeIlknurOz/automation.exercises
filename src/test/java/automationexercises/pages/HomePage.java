package automationexercises.pages;

import automationexercises.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//body")
    public WebElement body;
    @FindBy (xpath = "//a[@href=\"/login\"]")
    public WebElement signUpLogin;
    @FindBy (xpath = "//*[text()=' Logged in as '] ")
    public WebElement loggedIn;
    @FindBy(xpath = "//*[text()=' Delete Account']")
    public WebElement deleteAccount;

    @FindBy(xpath = "//a[@href=\"/logout\"]")
    public WebElement logOut;

    @FindBy(xpath = "//a[@href=\"/contact_us\"]")
    public WebElement contactUsButton;



}
