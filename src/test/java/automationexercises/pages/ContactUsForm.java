package automationexercises.pages;

import automationexercises.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsForm {
    public ContactUsForm() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.=\"Get In Touch\"]")
    public WebElement getInTouchText;
}
