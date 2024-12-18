package auto.appiumtest.tests;

import auto.appiumtest.screens.DetailedScreen;
import auto.appiumtest.screens.IntroScreen;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetailedTest extends BaseTest {

    private IntroScreen introScreen;
    private DetailedScreen detailedScreen;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
        introScreen = new IntroScreen(driver);
        detailedScreen = new DetailedScreen(driver);
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
}
