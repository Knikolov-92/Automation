package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
//====================================================================================\

}
