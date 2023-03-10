package pages.courseCategoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbsPage;

public class AbsCourseCategoryPage extends AbsPage {
    public AbsCourseCategoryPage (WebDriver driver, String path) {
        super(driver, "/");
    }

    @FindBy(css = ".sc-18q05a6-1~button")
    protected WebElement moreItemsButton;

    protected String courseSelector = "a[href='/lessons/%s']";


    public void showMoreItems() {
        click(moreItemsButton);
    }

    public void clickCourseLink(String coursePageName) {
        click(driver.findElement(By.cssSelector(String.format(courseSelector, coursePageName))));
    }
}