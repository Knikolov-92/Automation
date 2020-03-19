package utils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UtilRegPage {

//==========================================WebElements(locators)==========================================\
    @FindBy(how = How.CSS, using = "[method='post'].woocommerce-form.woocommerce-form-register.register")
    public WebElement RegisterForm;

    @FindBy(how = How.CSS, using = "label[for='reg_username']")
    public WebElement RegUsernameLabel;

    @FindBy(how = How.ID, using = "reg_username")
    public WebElement RegUsernameField;

    @FindBy(how = How.CSS, using = "label[for='reg_email']")
    public WebElement RegEmailLabel;

    @FindBy(how = How.ID, using = "reg_email")
    public WebElement RegEmailField;

    @FindBy(how = How.CSS, using = "label[for='reg_password']")
    public WebElement RegPasswordLabel;

    @FindBy(how = How.ID, using = "reg_password")
    public WebElement RegPasswordField;

    @FindBy(how = How.CSS, using = "[type='submit'][name='register'][value='Register']")
    public WebElement RegisterButton;

    @FindBy(how = How.CSS, using = "div.woocommerce-notices-wrapper ul.woocommerce-error[role='alert']")
    public WebElement RegInvalidUsernameError;

    @FindBy(how = How.CSS, using = "div.woocommerce-notices-wrapper ul.woocommerce-error[role='alert']")
    public WebElement RegInvalidEmailError;

    @FindBy(how = How.CSS, using = "div.woocommerce-notices-wrapper ul.woocommerce-error[role='alert']")
    public WebElement UsernameAlreadyTakenError;

    @FindBy(how = How.CSS, using = "div.woocommerce-notices-wrapper ul.woocommerce-error[role='alert']")
    public WebElement EmailAlreadyTakenError;
//====================================================================================\
    public void userEntersPersonalDetailsInRegForm( DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        if (data.get(0).get("username").isEmpty() ) {
            RegUsernameField.clear();
        }else{
            RegUsernameField.sendKeys(data.get(0).get("username"));
        }

        if (data.get(0).get("email").isEmpty() ) {
            RegEmailField.clear();
        }else{
            RegEmailField.sendKeys(data.get(0).get("email") );
        }

        if (data.get(0).get("password").isEmpty()) {
            RegPasswordField.clear();
        }else{
            RegPasswordField.sendKeys(data.get(0).get("password") );
        }
    }
//====================================================================================\
    public void UserShouldSeeTheRegisterButton() {

        Assert.assertTrue(RegisterButton.isDisplayed() );
    }
//====================================================================================\
}