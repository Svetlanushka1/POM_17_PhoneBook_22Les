import config.AppiumConfig;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationPositive(){
        int i = new Random().nextInt(1000) + 1000;

        new AuthenticationScreen(driver)
                .fillEmail("abc" + i + "@def.com")
                .fillPassword("$Abcdef12345")
                .submitRegistration()
                .isContactListActivityPresent()
        ;
    }

    @Test
    public void registrationWrongEmailNegative(){

        new AuthenticationScreen(driver)
                .fillEmail("wrong_emaildef.com")
                .fillPassword("$Abcdef12345")
                .submitRegistrationNegative()
                .isErrorMessageContainsText("username=must be a well-formed email address")
        ;
    }


}
