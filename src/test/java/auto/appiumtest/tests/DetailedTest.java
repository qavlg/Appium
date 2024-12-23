package auto.appiumtest.tests;

import auto.appiumtest.helpers.Actions;
import auto.appiumtest.screens.DetailedScreen;
import auto.appiumtest.screens.IntroScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class DetailedTest extends BaseTest {

    private IntroScreen introScreen;
    private DetailedScreen detailedScreen;
    private Actions actions;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
        introScreen = new IntroScreen(driver);
        detailedScreen = new DetailedScreen(driver);
        actions = new Actions(getDriver());
    }

    @Test
    @DisplayName("#2. The 'Тропарь святителя Геннадия' is shown in 17.12.2024 ")
    public void readAllPrayersTitleCheck() {
        int dayIndex = 23;

        introScreen.selectDayOfMonth(dayIndex);
        introScreen.commentButtonClick();
        detailedScreen.readAllPrayersButtonClick();

        assertEquals("Тропарь святителя Геннадия, архиепископа Новгородского", detailedScreen.readAllPrayersTitleCheck(),
                "Incorrect the title");
    }

    @Test
    @DisplayName("#3. The read evangelie and read all prayers buttons are enabled")
    public void nextAndPrevMonthButtonCheck() {
        introScreen.commentButtonClick();

        assertAll("Check two conditions",
                () -> assertTrue(detailedScreen.checkReadEvangelieButton(),
                        "read evangelie button is disabled"),
                () -> assertTrue(detailedScreen.checkReadAllPrayersButton(),
                        "read all prayers button is disabled")
        );
    }
}