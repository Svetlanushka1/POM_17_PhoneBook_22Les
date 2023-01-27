package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {

    AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void type(MobileElement element, String text){
        if(text == null) return;
        element.click();
        element.clear();
        element.sendKeys(text);
        driver.hideKeyboard();
    }

    public void pause(int time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }

    public void waitElement(MobileElement element, int time){
        new WebDriverWait(driver, time).until(
                ExpectedConditions.visibilityOf(element)
        );
    }

    public boolean shouldHave(MobileElement element, String text, int time){
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
