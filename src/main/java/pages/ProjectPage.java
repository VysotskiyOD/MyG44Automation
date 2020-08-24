package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ProjectPage extends BasePage{
    private LoginPage loginPage;
    protected final Logger log = LogManager.getLogger("Project Page");

    private final By usernameField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By projectGoToFileXpath = By.xpath(property.getProperty("projectGoToFileXpath"));
    //private final By projectUrl = By.xpath(property.getProperty("projectUrl"));
    private final By signOutXpath=By.xpath(property.getProperty("signOutXpath"));

    public ProjectPage(WebDriver driver){
        super(driver);
    }

    public ProjectPage login(String username, String password) {
        validateTrue(this.driver.findElement(usernameField));
        validateTrue(this.driver.findElement(passwordField));
        validateTrue(this.driver.findElement(signInButton));
        this.driver.findElement(usernameField).sendKeys(username);
        this.driver.findElement(passwordField).sendKeys(password);
        this.driver.findElement(signInButton).click();
        validateTrue(this.driver.findElement(signOutXpath));
        this.driver.findElement(signOutXpath);
        return this;
    }

    public ProjectPage reject(ProjectPage login){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(property.getProperty("projectUrl"));
        return new ProjectPage(this.driver);

    }

    private void validateTrue(WebElement element){
        log.debug("Start test for enabled true for element: " + element);
        Assert.assertTrue(element.isEnabled());
        log.debug("Test finished");
    }
}
