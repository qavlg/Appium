package auto.appiumtest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class IntroScreen {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(IntroScreen.class));

    @AndroidFindBy(id = "nextMonth")
    private WebElement nextMonthButton;

    @AndroidFindBy(id = "comment")
    private WebElement comment;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.neosphere.ocalendar:id/read_all_prayers_btn']")
    private WebElement readAllPrayers;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.neosphere.ocalendar:id/prayer_title' and @text='Тропарь святителя Геннадия, архиепископа Новгородского']")
    private WebElement readAllPrayersTitle;


    public boolean checkNextMonthButton() {
        LOG.info("Check whether the next button is enable");
        return nextMonthButton.isEnabled();
    }

    public void commentButtonClick() {
        LOG.info("Click on the comment button");
        comment.click();
    }

    public void readAllPrayersButtonClick() {
        LOG.info("Click on the read all prayers button");
        readAllPrayers.click();
    }

    public String readAllPrayersTitleCheck() {
        LOG.info("Check whether the read all prayers title is correct");
        return readAllPrayersTitle.getText();
    }

    public IntroScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}