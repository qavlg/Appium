package auto.appiumtest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class IntroScreen {

    @AndroidFindBy(id = "nextMonth")
    private WebElement skipButton;

    public boolean checkSkipButton() {
        return skipButton.isEnabled();
    }

    public IntroScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
