package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver ldriver){
        this.driver=ldriver;
        PageFactory.initElements(ldriver,this);
    }

    @FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[2]/a") WebElement logimage;

    @FindBy(id = "email") WebElement email;

    @FindBy(id = "password") WebElement pass;

    @FindBy(id = "customerloginForm") WebElement sub;


    public void portalLogin(String username, String password){
        System.out.println("Hi");
        logimage.click();
        email.sendKeys(username);
        pass.sendKeys(password);
        sub.click();
    }
}
