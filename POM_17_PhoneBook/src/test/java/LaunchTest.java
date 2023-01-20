import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LaunchTest extends AppiumConfig {

    @Test
    public void launch(){
        String version = new SplashScreen(driver).getCurrentVersion();
        System.out.println("Version = " + version);
        Assert.assertTrue((version.contains("1.0.0")));
    }
}
