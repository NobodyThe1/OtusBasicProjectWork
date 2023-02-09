package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EventsPage extends AbsPage {

    public EventsPage(WebDriver driver) {
        super(driver, "/events/near/");
    }

    @FindBy (css = ".dod_new-events-dropdown")
    private WebElement eventsDropDown;

    private String eventSelector = ".dod_new-events-dropdown__list-item[title='%s']";


    public void openEventsDropDown() {
        clickAndPerform(eventsDropDown);
    }

    public void selectEvent(String eventTitle) {
        waiter.waitForCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dod_new-events-dropdown_opened")));
        click(driver.findElement(By.cssSelector(String.format(eventSelector, eventTitle))));
    }

    public void scrollPage() {
        for (int i = 0; i <= 100; i++) {
            ((JavascriptExecutor)driver).executeScript("document.querySelector('.footer2__container')" +
                            ".scrollIntoView({behavior: 'smooth'});" +
                            "document.querySelector('.footer2__container')" +
                            ".scrollIntoView(false);");
            waiter.waitForCondition(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(By.cssSelector(".dod_new-event-content")));
        }
    }
}