package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbsPage {
    public MainPage(WebDriver driver) {
        super(driver, "/");
    }

    private String courseCategorySelector = ".course-categories__nav-item[title='%s']";


    public void openCoursePage(String courseCategoryTitle) {
        click(driver.findElement(By.cssSelector(String.format(courseCategorySelector, courseCategoryTitle))));
    }
}