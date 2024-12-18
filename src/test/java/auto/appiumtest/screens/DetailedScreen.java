package auto.appiumtest.screens;

import auto.appiumtest.allure.AllureLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import io.appium.java_client.android.AndroidKeyCode;

import static auto.appiumtest.tests.BaseTest.driver;

public class DetailedScreen {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DetailedScreen.class));

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.neosphere.ocalendar:id/read_all_prayers_btn']")
    private WebElement readAllPrayers;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Тропарь святителя Геннадия, архиепископа Новгородского\")")
    private WebElement readAllPrayersTitle;


    public void readAllPrayersButtonClick() {
        LOG.info("Click on the read all prayers button");
        readAllPrayers.click();
    }

    public String readAllPrayersTitleCheck() {
        LOG.info("Check whether the read all prayers title is correct");
        return readAllPrayersTitle.getText();
    }

    public void pressBackButton() {
        LOG.info("Press system back button");
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    public DetailedScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
