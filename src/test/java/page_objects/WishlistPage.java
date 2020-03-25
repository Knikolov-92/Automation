package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WishlistPage {

    @FindBy(className = "wishlist-items-wrapper")
    List<WebElement> wishlistTable;

    private WebDriver driver;
    private final static String WEB_PAGE_URL = "https://shop.demoqa.com/wishlist/";

    public WishlistPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void open(){
        driver.get(WEB_PAGE_URL);
    }

    public String getEmptyMessage(){

        try {
            return wishlistTable.get(0)
                    .getText();
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            return "";
        }
    }

    public int getSize(){

        return wishlistTable.size();
    }
}
