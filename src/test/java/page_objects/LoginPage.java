package page_objects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


public class LoginPage extends RegistrationPage {

//==========================================WebElements(locators)==========================================\

    @FindBy(id = "username")
    public WebElement loginUsernameField;

    @FindBy(id = "password")
    public WebElement loginPasswordField;

    @FindBy(name = "login")
    public WebElement loginButton;

    @FindBy(name = "rememberme")
    public WebElement loginRrememberMeCheckBox;

    @FindBy(css = "p.woocommerce-LostPassword.lost_password")
    public WebElement loginLostPasswordLink;

    @FindBy(css = "label[for='username']")
    public WebElement loginUsernameLabel;

    @FindBy(css = "label[for='password']")
    public WebElement loginPasswordLabel;

    @FindBy(how = How.CSS, using = "div.woocommerce-notices-wrapper ul.woocommerce-error[role='alert']")
    public WebElement loginInvalidInputErrorMessage;

//====================================================================================\
    //init Webelements on Login page
    public void initLoginElements(){

        PageFactory.initElements(driver, this);
    }

//====================================================================================\
    //Check Login Form is displayed with all the elements
    public void checkLoginForm() {

        WebElement[] elementsArray = {
                loginUsernameLabel, loginUsernameField,
                loginPasswordLabel, loginPasswordField,
                loginButton, loginRrememberMeCheckBox,
                loginLostPasswordLink,
                };
//------------------------------------------------------------
        for (int n = 0; n < elementsArray.length; n++) {

            Assert.assertTrue(elementsArray[n].isDisplayed());
        }
    }
//====================================================================================\
    //check for correct error text upon invalid login input submitted
    public void checkLoginErrorMessage(String expectedErrorText) {

        Assert.assertTrue(loginInvalidInputErrorMessage.isDisplayed() );
        Assert.assertEquals(loginInvalidInputErrorMessage.getText(), expectedErrorText);
    }
//====================================================================================\
    //click on login button
    public void loginButtonIsClicked() throws InterruptedException {

        loginButton.click();
        Thread.sleep(3000);
    }
//====================================================================================\
    //enter username/email and password in Login form
    public void userEntersPersonalDetailsInLoginForm( DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        if (data.get(0).get("username") != null) {

            loginUsernameField.sendKeys(data.get(0).get("username"));
        }
        Thread.sleep(1000);

        if  (data.get(0).get("password") != null) {

            loginPasswordField.sendKeys(data.get(0).get("password") );
        }
        Thread.sleep(1000);
    }


}
