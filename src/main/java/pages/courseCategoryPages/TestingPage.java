package pages.courseCategoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbsPage;

public class TestingPage extends AbsCourseCategoryPage {
    public TestingPage(WebDriver driver) {
            super(driver, "/catalog/courses?categories=testing");
    }


    private String coursePageName = "java-qa-pro";
    public String getCoursePageName() {
        return coursePageName;
    }
}