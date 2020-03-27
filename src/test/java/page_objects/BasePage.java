package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    public static Properties properties = new Properties();
    public final static String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    public final static String CHROME_DRIVER_PATH = "src/test/resources/drivers/chromedriver.exe";

//====================================================================================\
    //Set up driver to use Chrome, open browser window, maximize it and delete cookies
    public static void initializeBrowser() {

        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
//====================================================================================\
    //This will scroll the page until an element is found:
    public void scrollWindow(WebElement elementToScrollTo) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(elementToScrollTo);
        actions.perform();

        Thread.sleep(500);
    }
//====================================================================================\
    //switch to 1st tab(if others are open - close them first)
    public void endWindowSession() throws InterruptedException {

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        if (tabs.size()  > 1)
        {
            for(int iCount = 2; iCount <= tabs.size(); iCount++){

                driver.close();
                Thread.sleep(3);
            }
        }
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(1000);
    }
//====================================================================================\
    //closes browser window, controlled by webdriver
    public void endBrowserSession() {
        driver.quit();
    }
//====================================================================================\
    //navigate to some URL
    public void navigateToURL(String targetURL) throws InterruptedException {
        driver.get(targetURL);
        Thread.sleep(3000);
    }
//====================================================================================\
    //check a Web Element is displayed
    public void checkWebElementIsDisplayed(WebElement webElement) {

        Assert.assertTrue(webElement.isDisplayed() );
    }

}
