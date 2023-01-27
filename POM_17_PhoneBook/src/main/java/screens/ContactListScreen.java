package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ContactListScreen extends BaseScreen {
    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement moreOption;
    @FindBy(id = "com.sheygam.contactapp:id/add_contact_btn")
    MobileElement plusButton;
    @FindBy(id = "com.sheygam.contactapp:id/title")
    MobileElement logoutButton;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityViewText;

    public ContactListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean isContactListActivityPresent() {
        return shouldHave(activityViewText, "Contact list", 5);
    }

    public AuthenticationScreen logout() {
        moreOption.click();
        logoutButton.click();
        return new AuthenticationScreen(driver);
    }

    public AddNewContactScreen openContactForm(){
        waitElement(plusButton, 5);
        plusButton.click();
        return new AddNewContactScreen(driver);
    }
}
