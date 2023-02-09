package components;

import data.MonthsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;

public class EventsTiles extends AbsComponent {

    public EventsTiles(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dod_new-event__time")
    List<WebElement> eventsWebelementList;

    @FindBy(css = ".dod_new-event__type")
    List<WebElement> dodList;

    public void eventTypeShouldBeSameAs(String eventType) {
        for (WebElement element : dodList) {
            Assertions.assertTrue(element.getText().contains(eventType));
        }
    }

    public void eventsTilesShouldBeDisplayed() {
        checkVisibilityOfElements(driver.findElement(By.cssSelector(".dod_new-event__time")));
    }

    public void checkEventsDate() {
        List<String> eventsListToString = new ArrayList<>();
        List<LocalDateTime> eventsDateList = new ArrayList<>();
        String monthOfEvent;
        String dateOfEvent;

        for (WebElement element : eventsWebelementList) {
            eventsListToString.add(element.getText());
        }
        for (String string : eventsListToString) {
            monthOfEvent = string.split(" ")[1];

            dateOfEvent = string.replaceAll("[а-я]+", String.format("%d", MonthsData.getDate(monthOfEvent).getNumber()));
            dateOfEvent += " " + LocalDate.now().getYear();
            dateOfEvent = dateOfEvent.charAt(0) + dateOfEvent.substring(1).toLowerCase();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM HH:mm yyyy", Locale.ROOT);
            LocalDateTime localDateTime = LocalDateTime.parse(dateOfEvent, formatter);

            if (localDateTime.equals("Сейчас в эфире")) {
                eventsDateList.add(LocalDateTime.now());
            } else {
                eventsDateList.add(localDateTime);
            }
        }
        for (LocalDateTime localDateTime : eventsDateList) {
            Assertions.assertTrue(localDateTime
                    .isAfter(localDateTime.now()) || localDateTime.isEqual(localDateTime.now()));
        }
    }
}