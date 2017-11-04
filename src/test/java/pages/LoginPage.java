package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://dropbox.com/login");
    }

    @FindBy(css = "input.autofocus[type = email]")
    public WebElement loginInput;

    @FindBy(css = "input.password-input.text-input-input[name=\"login_password\"]")
    public WebElement passwordInput;

    @FindBy(css = "div.clearfix > button")
    public WebElement LoginButton;


}
