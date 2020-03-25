package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;

import page_objects.WishlistPage;

public class Wishlist {

    private WebDriver driver;
    private WishlistPage wishlist;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        wishlist = new WishlistPage(driver);

    }

    @Given("No items have been added to the wishlist")
    public void no_items_have_been_added_to_the_wishlist() {
        driver.manage().deleteAllCookies();
    }

    @When("The user navigates to My Wishlist page")
    public void the_user_navigates_to_My_Wishlish_page() {
        wishlist.open();
    }

    @Then("The user should see {string} message")
    public void the_user_should_see_message(String message) {
        assertEquals(message, wishlist.getEmptyMessage());
    }

//    @When("The user adds item to their wishlist")
//    public void the_user_adds_item_to_their_wishlist() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @And("They navigate to My Wishlist page")
//    public void they_navigate_to_My_Wishlist_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the item should appear in the wishlist")
//    public void the_item_should_appear_in_the_wishlist() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

    @After
    public void tearDown(){
        driver.close();
    }
}
