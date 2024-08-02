package pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import utilities.BrowserFactoryClass;
import utilities.ConfigDataClass;

public class BaseClass {
    WebDriver driver;
    public ConfigDataClass conf = new ConfigDataClass();

    @BeforeClass
    public void setup(){
        driver= BrowserFactoryClass.startApplication(driver, conf.getBrowser(), conf.getUrl());
    }
}
