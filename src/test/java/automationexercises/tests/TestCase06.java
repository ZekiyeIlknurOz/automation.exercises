package automationexercises.tests;

import automationexercises.pages.ContactUsForm;
import automationexercises.pages.HomePage;
import automationexercises.pages.LoginPage;
import automationexercises.utilities.ConfigReader;
import automationexercises.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase06 {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ContactUsForm contactUsForm =new ContactUsForm();


    @Test
    public void contactUsForm() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.body.isDisplayed());

        //4. Click on 'Contact Us' button
        homePage.contactUsButton.click();

        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(contactUsForm.getInTouchText.isDisplayed());

        //6. Enter name, email, subject and message
        //7. Upload file
        //8. Click 'Submit' button
        //9. Click OK button
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        //11. Click 'Home' button and verify that landed to home page successfully
    }
}
