package auto.appiumtest.tests;

import auto.appiumtest.helpers.Actions;
import auto.appiumtest.screens.IntroScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntroScreenTest extends BaseTest {

    private IntroScreen introScreen;
    private Actions actions;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
        introScreen = new IntroScreen(getDriver());
        actions = new Actions(getDriver());
    }

    @Test
    @DisplayName("#1. The Next month button and prev button are enabled")
    public void nextAndPrevMonthButtonCheck() {

        assertAll("Check two conditions",
                () -> assertTrue(introScreen.checkNextMonthButton(),
                        "Next month button is disabled"),
                () -> assertTrue(introScreen.checkPrevMonthButton(),
                        "Prev month button is disabled")
        );
    }

    @Test
    @DisplayName("#4. The settings button is enabled")
    public void settingsButtonCheck() {
        actions.scroll();

        assertTrue(introScreen.checkSettingsButton(),
                "Settings button is disabled");
    }

    @Test
    @DisplayName("#5. The next month button is enabled after clicking on the back button")
    public void backwardsActionCheck() {
        introScreen.commentButtonClick();
        actions.pressBackButton();

        assertTrue(introScreen.checkNextMonthButton(),
                "Next month button is disabled");
    }

    @Test
    @DisplayName("#6. The next month button is disabled after clicking on the home button")
    public void homeActionCheck() {
        actions.pressAppSwitchButton();
        introScreen.taskViewElementClick();

        assertTrue(introScreen.checkNextMonthButton(),
                "Next month button is disabled");
    }
}