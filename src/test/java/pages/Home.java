package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Page {

    public Home(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.appactions-menu > div > div > div > button")
    public WebElement uploadButton;

    @FindBy(xpath = "//*[@id=\"inline-upload-status\"]//span[4]/button")
    public WebElement sucsessBUtton;
}
