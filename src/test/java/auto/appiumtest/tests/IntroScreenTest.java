package auto.appiumtest.tests;

import auto.appiumtest.screens.IntroScreen;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;

import static java.sql.DriverManager.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntroScreenTest extends BaseTest {

    private IntroScreen introScreen;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
        introScreen = new IntroScreen(getDriver());
    }

    @Test
    @DisplayName("#1. The Next month button is enabled")
    public void NextMonthButtonCheck() {
        assertTrue(introScreen.checkNextMonthButton(), "Next month button is disabled");
    }
}