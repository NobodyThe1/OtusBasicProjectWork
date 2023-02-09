package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Menu extends AbsComponent {

    public Menu(WebDriver driver) {
        super(driver);
    }

    private String menuItemSelector = ".header3__nav-item[data-name='%s']";
    private String learningSubMenuItemSelector = ".header3__nav-column-item[href='%s']";


    public void openMenuItem(String item) {
        perform(driver.findElement(By.cssSelector(String.format(menuItemSelector, item))));
    }

    public void clickLearningSubmenuItem(String item) {
        waiter.waitForCondition(ExpectedConditions.not(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(".js-header3-popup[data-name='learning'][style='display: none;']"))));
        waiter.waitForCondition(ExpectedConditions.visibilityOf((driver.findElement(By.cssSelector(String.format(learningSubMenuItemSelector, item))))));
        click(driver.findElement(By.cssSelector(String.format(learningSubMenuItemSelector, item))));
    }
}