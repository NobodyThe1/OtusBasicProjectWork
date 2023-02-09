import components.Menu;
import components.EventsTiles;
import components.LessonsTiles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.EventsPage;
import pages.coursePages.JavaQAProPage;
import pages.MainPage;
import pages.courseCategoryPages.TestingPage;

import java.text.ParseException;

public class OtusProjectTests {

    private WebDriver driver;

    @BeforeAll
    public static void start() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        new MainPage(driver).open();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


    @Test
    public void countLessonsTiles() {
        MainPage mainPage = new MainPage(driver);
        TestingPage testingPage = new TestingPage(driver);
        LessonsTiles lessonsTiles = new LessonsTiles(driver);

        mainPage.openCoursePage("Тестирование");
        testingPage.showMoreItems();
        lessonsTiles.lessonsTilesShouldBeDisplayed();
        lessonsTiles.numberOfLessonsTilesShouldBeSameAs(12);
    }

    @Test
    public void lessonsInfoIsDisplayed() {
        MainPage mainPage = new MainPage(driver);
        TestingPage testingPage = new TestingPage(driver);
        JavaQAProPage javaQAProPage = new JavaQAProPage(driver);

        mainPage.openCoursePage("Тестирование");
        testingPage.clickCourseLink(testingPage.getCoursePageName());
        javaQAProPage.courseTitleShouldBeSameAs(javaQAProPage.getCourseTitleText());
        javaQAProPage.courseDescriptionShouldBeSameAs(javaQAProPage.getCourseDescriptionText());
        javaQAProPage.courseDurationShouldBeSameAs(javaQAProPage.getCourseDurationText());
        javaQAProPage.courseFormatShouldBeSameAs(javaQAProPage.getCourseFormatText());
    }

    @Test
    public void checkEventDate() {
        Menu menu = new Menu(driver);
        EventsPage eventsPage = new EventsPage(driver);
        EventsTiles eventsTiles = new EventsTiles(driver);

        menu.openMenuItem("learning");
        menu.clickLearningSubmenuItem("/events/near/");
        eventsPage.scrollPage();
        eventsTiles.eventsTilesShouldBeDisplayed();
        eventsTiles.checkEventsDate();
    }

    @Test
    public void sortEventsByType() {
        EventsPage eventsPage = new EventsPage(driver);
        EventsTiles eventsTiles = new EventsTiles(driver);
        Menu menu = new Menu(driver);

        menu.openMenuItem("learning");
        menu.clickLearningSubmenuItem("/events/near/");
        eventsPage.openEventsDropDown();
        eventsPage.selectEvent("ДОД");
        eventsTiles.eventTypeShouldBeSameAs("День открытых дверей");
    }
}