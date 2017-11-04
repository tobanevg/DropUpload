package app;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.Home;
import pages.LoginPage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Application {
    private String userEmail = "tobanevg@gmail.com";
    private String userPassword = "1q1q1q";
    private WebDriver driver;
    protected WebDriverWait wait;
    private Home home;
    private LoginPage loginPage;
    final String fileName = "imScreenshot.png";
    final String filePath = "/home/berion/" + fileName;


    public Application() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        home = new Home(driver);
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public void login() {
        loginPage.open();
        loginPage.loginInput.sendKeys(userEmail);
        loginPage.passwordInput.sendKeys(userPassword);
        loginPage.LoginButton.click();
    }

    public void upload() {
        wait.until(ExpectedConditions.visibilityOf(home.uploadButton));
        home.uploadButton.click();
        fileUpload(filePath);
    }

    public void assertion() {
        wait.until(ExpectedConditions.visibilityOf(home.sucsessBUtton));
        Assert.assertTrue(home.sucsessBUtton.isDisplayed());
    }

    public void fileUpload(String filePath) {
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Robot robot;
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}

