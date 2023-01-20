package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {

    public static AppiumDriver<MobileElement> driver;

    /*
{
  "platformName": "Android",
  "deviceName": "Nex",
  "platformVersion": "8.0",
  "appPackage": "com.sheygam.contactapp",
  "appActivity": ".SplashActivity"
}
     */

    @BeforeSuite
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Nex");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("appPackage","com.sheygam.contactapp");
        capabilities.setCapability("appActivity",".SplashActivity");

        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:\\Tools\\APK\\contacts-android.apk");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    };

}
