package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private  WebDriver driver;
    private final static String WEB_PAGE_URL = "https://shop.demoqa.com/my-account/";

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(name = "login")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[4]/a")
    WebElement lostPasword;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void open(){
        driver.get(WEB_PAGE_URL);
    }
}
