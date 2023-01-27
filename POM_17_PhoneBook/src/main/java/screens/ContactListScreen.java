package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.Contact;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactListScreen extends BaseScreen {
    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement moreOption;
    @FindBy(id = "com.sheygam.contactapp:id/add_contact_btn")
    MobileElement plusButton;
    @FindBy(id = "com.sheygam.contactapp:id/title")
    MobileElement logoutButton;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityViewText;
    @FindBy(id = "android:id/button1")
    MobileElement yesButton;



    @FindBy(id = "com.sheygam.contactapp:id/rowName")
    List<MobileElement> names;
    @FindBy(id = "com.sheygam.contactapp:id/rowPhone")
    List<MobileElement> phones;
    @FindBy(id = "com.sheygam.contactapp:id/rowContainer")
    List<MobileElement> contacts;

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

    public ContactListScreen isContactAdded(Contact contact){
        boolean checkName = checkContainsText(names, contact.getName());
        boolean checkPhone = checkContainsText(phones, contact.getPhone());
        Assert.assertTrue(checkPhone&&checkName);
        return this;
    }

    public boolean checkContainsText(List<MobileElement> list, String text){
        for (MobileElement e : list){
            if(e.getText().contains(text)){
                return true;
            }
        }
        return false;
    }

    public ContactListScreen removeOneContact(){
        waitElement(plusButton, 5);
//        pause(5);
        MobileElement contact = contacts.get(0);
        System.out.println("Length = " + contacts.size());
        Rectangle rect = contact.getRect();

        int xStart = rect.getX() + rect.getWidth() / 8;
        int xEnd = xStart + rect.getWidth() * 6 / 8;
        int y = rect.getHeight() / 2;
        System.out.println(xStart + "\n" + xEnd + "\n" + y);

        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(xStart, y))
                .moveTo(PointOption.point(xEnd, y))
                .release()
                .perform();
//        waitElement(yesButton, 5);
        yesButton.click();
        pause(5);
        return this;
    }
}
