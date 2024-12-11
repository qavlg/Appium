package auto.appiumtest;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntroScreenTest {

    private AndroidDriver driver;

    private IntroScreen introScreen;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:app", "C:\\\\Users\\\\aleks\\\\OneDrive\\\\Рабочий стол\\\\Православный календарь_1.34_APKPure.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium: deviceName", "testDevice");
        desiredCapabilities.setCapability("appium: automationName", "uiAutomator2");
        desiredCapabilities.setCapability("appium: ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium: nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium: newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwarekeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        introScreen = new IntroScreen(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void skipCheck() {
        assertTrue(introScreen.checkSkipButton(), "Нeт кнопки пропуска обучения");
    }
}