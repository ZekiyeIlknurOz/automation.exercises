package automationexercises.pages;

import automationexercises.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    public SignUpPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[@id='id_gender1']")
    public WebElement cinsiyet;
    @FindBy (xpath =  "//*[@id='password']")
    public WebElement password;
    @FindBy (id = "days")
    public WebElement day;
    @FindBy (id = "months")
    public WebElement month;
    @FindBy (id = "years")
    public WebElement year;
    @FindBy (id = "first_name")
    public WebElement firstName;
    @FindBy (id = "last_name")
    public WebElement lastName;
    @FindBy (id = "address1")
    public WebElement address1;
    @FindBy (id = "country")
    public WebElement country;
    @FindBy (id = "state")
    public WebElement state;
    @FindBy (id = "city")
    public WebElement city;
    @FindBy (id = "zipcode")
    public WebElement zipcode;
    @FindBy (id = "mobile_number")
    public WebElement mobileNumber;
    @FindBy (xpath = "//*[.='Create Account']")
    public WebElement createAccount;




}
