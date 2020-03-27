package stepdefs;

import io.cucumber.java.en.But;
import page_objects.BasePage;

public class BaseSteps {

    private BasePage basePage = new BasePage();

//====================================================================================\
    @But("^The browser should close$")
    public void browserIsClosed() {

        basePage.endBrowserSession();
    }
//====================================================================================\
    @But("^The window is closed$")
    public void windowIsClosed() throws InterruptedException {

        basePage.endWindowSession();
    }

}
