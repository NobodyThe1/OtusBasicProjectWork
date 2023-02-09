package pages.coursePages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbsPage;

public class JavaQAProPage extends AbsCoursePage {

    public JavaQAProPage(WebDriver driver) {
        super(driver, "/lessons/java-qa-pro/");
    }


    private String courseTitleText = "Java QA Engineer. Professional";
    private String courseDescriptionText = "Автоматизация тестирования на Java продвинутого уровня";
    private String courseDurationText = "4 месяца";
    private String courseFormatText = "Online";

    public String getCourseTitleText() {
        return courseTitleText;
    }

    public String getCourseDescriptionText() {
        return courseDescriptionText;
    }

    public String getCourseDurationText() {
        return courseDurationText;
    }

    public String getCourseFormatText() {
        return courseFormatText;
    }
}