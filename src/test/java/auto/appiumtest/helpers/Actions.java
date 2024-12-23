package auto.appiumtest.helpers;

import auto.appiumtest.allure.AllureLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static auto.appiumtest.tests.BaseTest.driver;

public class Actions {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(Actions.class));

    public void scroll() {
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.8);
        int endY = (int) (screenHeight * 0.2);

        new org.openqa.selenium.interactions.Actions(driver)
                .moveToLocation(startX, startY)
                .clickAndHold()
                .moveToLocation(startX, endY)
                .release()
                .perform();
        LOG.info("Make scroll down");
    }

    public void pressBackButton() {
        LOG.info("Press system back button");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    public void pressHomeButton() {
        LOG.info("Press system back button");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
    }

    public void pressAppSwitchButton() {
        LOG.info("Press app switch button");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.APP_SWITCH));
    }

    public Actions(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
}
