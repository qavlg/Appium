package auto.appiumtest.screens;

import auto.appiumtest.allure.AllureLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

public class IntroScreen {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(IntroScreen.class));

    @AndroidFindBy(id = "nextMonth")
    private WebElement nextMonthButton;

    @AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.neosphere.ocalendar:id/calendar_day_gridcell\"])")
    private List<WebElement> daysOfMonth;

    @AndroidFindBy(id = "prevMonth")
    private WebElement prevMonthButton;

    @AndroidFindBy(id = "current_month")
    private WebElement currentMonth;

    @AndroidFindBy(id = "comment")
    private WebElement comment;

    public void selectDayOfMonth(int index) {
        if (currentMonth.getText().equals("Декабрь")) {
            if (index >= 1 && index <= daysOfMonth.size()) {
                daysOfMonth.get(index - 1).click();
            } else {
                throw new IndexOutOfBoundsException("Invalid day index: " + index);
            }
        } else {
            prevMonthButton.click();
            selectDayOfMonth(index);
        }
    }

    public boolean checkNextMonthButton() {
        LOG.info("Check whether the next button is enable");
        return nextMonthButton.isEnabled();
    }

    public void commentButtonClick() {
        comment.click();
        LOG.info("Click on the comment button");
    }

    public IntroScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}