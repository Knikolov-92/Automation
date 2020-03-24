package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    public static Properties properties = new Properties();

//====================================================================================\
    public static void initializeBrowser(String inputURL){

        String outputURL;

        try {
            FileInputStream browserConfig = new FileInputStream("src/test/resources/browser-config.properties");
            properties.load(browserConfig);
        } catch (IOException e) {
            e.getMessage();
        }

        if (properties.getProperty("browser").equals("Chrome")) {

            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            // }else{ more browsers...}
        }

        driver.manage().window().maximize();

        switch (inputURL) {

            case "baseURL":
                outputURL = properties.getProperty("baseURL");
                break;
            case "myAccountURL":
                outputURL = properties.getProperty("myAccountURL");
                break;
            default:
                outputURL = properties.getProperty("baseURL");
        }
        driver.get(outputURL);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
//====================================================================================\
    public void scrollWindow(WebElement elementToScrollTo) throws InterruptedException {

        //This will scroll the page until an element is found:
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToScrollTo);
        actions.perform();

        Thread.sleep(500);
    }
//====================================================================================\
    public void endWindowSession() throws InterruptedException {

        //switch to 1st tab(if others are open - close them first)
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
    public void endBrowserSession(){
        driver.quit();
    }
//====================================================================================\
}
