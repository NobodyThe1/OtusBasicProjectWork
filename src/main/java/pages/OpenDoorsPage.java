package pages;

import org.openqa.selenium.WebDriver;

public class OpenDoorsPage extends AbsPage {
    public OpenDoorsPage(WebDriver driver) {
        super(driver, "/events/near/open_doors/");
    }
}