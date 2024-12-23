package auto.appiumtest.screens;

import auto.appiumtest.allure.AllureLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class DetailedScreen {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DetailedScreen.class));

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.neosphere.ocalendar:id/read_all_prayers_btn']")
    private WebElement readAllPrayers;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Тропарь святителя Геннадия, архиепископа Новгородского\")")
    private WebElement readAllPrayersTitle;

    @AndroidFindBy(id = "read_evangelie")
    private WebElement readEvangelie;

    public void readAllPrayersButtonClick() {
        LOG.info("Click on the read all prayers button");
        readAllPrayers.click();
    }

    public String readAllPrayersTitleCheck() {
        LOG.info("Check whether the read all prayers title is correct");
        return readAllPrayersTitle.getText();
    }

    public boolean checkReadEvangelieButton() {
        LOG.info("Check whether the read evangelie button is enabled");
        return readEvangelie.isEnabled();
    }

    public boolean checkReadAllPrayersButton() {
        LOG.info("Check whether the read all prayers button is enabled");
        return readAllPrayers.isEnabled();
    }

    public DetailedScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}