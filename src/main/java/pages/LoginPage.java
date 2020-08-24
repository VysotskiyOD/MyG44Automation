package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    protected final Logger log = LogManager.getLogger("Login Page");

    private final By usernameField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By errorMessage = By.xpath("//div[@class = 'container-lg px-2']");
    private final By signOutXpath=By.xpath(property.getProperty("signOutXpath"));
    private final By projectGoToFileXpath = By.xpath(property.getProperty("projectGoToFileXpath"));
    private final By projectPomFIle = By.xpath(property.getProperty("projectPomFIle"));
    private final By seleniumXpath = By.xpath(property.getProperty("seleniumXpath"));
    private final By profileButton = By.xpath(property.getProperty("profileButton"));
    private final By infoAfterLogout = By.xpath(property.getProperty("infoAfterLogout"));


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public MainPage login(){
        validateTrue(this.driver.findElement(usernameField));
        validateTrue(this.driver.findElement(passwordField));
        validateTrue(this.driver.findElement(signInButton));


        this.driver.findElement(usernameField).sendKeys(System.getProperty("username"));
        this.driver.findElement(passwordField).sendKeys(System.getProperty("password"));
        this.driver.findElement(signInButton).click();

        return new MainPage(this.driver);
    }

    public LoginPage login(String username, String password){
        //login
        validateTrue(this.driver.findElement(usernameField));
        validateTrue(this.driver.findElement(passwordField));
        validateTrue(this.driver.findElement(signInButton));
        this.driver.findElement(usernameField).sendKeys(username);
        this.driver.findElement(passwordField).sendKeys(password);
        this.driver.findElement(signInButton).click();
        validateTrue(this.driver.findElement(signOutXpath));
        this.driver.findElement(signOutXpath);
        return new LoginPage(this.driver);

    }

    public LoginPage reject(String username, String password, String URL){
        validateTrue(this.driver.findElement(usernameField));
        validateTrue(this.driver.findElement(passwordField));
        validateTrue(this.driver.findElement(signInButton));
        this.driver.findElement(usernameField).sendKeys(username);
        this.driver.findElement(passwordField).sendKeys(password);
        this.driver.findElement(signInButton).click();
        validateTrue(this.driver.findElement(signOutXpath));
        this.driver.findElement(signOutXpath);
        //->BKuso/G44Automation
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(URL);
        validateTrue(this.driver.findElement(projectGoToFileXpath));
        this.driver.findElement(projectGoToFileXpath).click();
        return new LoginPage(this.driver);
    }

    public LoginPage pomFile(String username, String password, String URL, String pomXpath){

        validateTrue(this.driver.findElement(usernameField));
        validateTrue(this.driver.findElement(passwordField));
        validateTrue(this.driver.findElement(signInButton));
        this.driver.findElement(usernameField).sendKeys(username);
        this.driver.findElement(passwordField).sendKeys(password);
        this.driver.findElement(signInButton).click();
        validateTrue(this.driver.findElement(signOutXpath));
        this.driver.findElement(signOutXpath);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(URL);
        //go to file
        validateTrue(this.driver.findElement(projectGoToFileXpath));
        this.driver.findElement(projectGoToFileXpath).click();
        //add find POM file
        validateTrue(this.driver.findElement(projectPomFIle));
        this.driver.findElement(projectPomFIle).click();
        return new LoginPage(this.driver);
    }

    public LoginPage pomFileFindSelenium(String username, String password, String URL, String pomXpath){

        validateTrue(this.driver.findElement(usernameField));
        validateTrue(this.driver.findElement(passwordField));
        validateTrue(this.driver.findElement(signInButton));
        this.driver.findElement(usernameField).sendKeys(username);
        this.driver.findElement(passwordField).sendKeys(password);
        this.driver.findElement(signInButton).click();
        validateTrue(this.driver.findElement(signOutXpath));
        this.driver.findElement(signOutXpath);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(URL);
        validateTrue(this.driver.findElement(projectGoToFileXpath));
        this.driver.findElement(projectGoToFileXpath).click();
        validateTrue(this.driver.findElement(projectPomFIle));
        this.driver.findElement(projectPomFIle).click();
        //add find selenium version
        validateTrue(this.driver.findElement(seleniumXpath));
        log.info("Version Selenium: " + driver.findElement(seleniumXpath).getText()
                .replaceAll("<version>","")
                .replaceAll("</version>","")
                .replaceAll("            ",""));
        Assert.assertEquals("3.141.59", driver.findElement(seleniumXpath).getText()
                .replaceAll("<version>","")
                .replaceAll("</version>","")
                .replaceAll("            ",""));
        return new LoginPage(this.driver);
    }

    public LoginPage SignOutProfile(String username, String password, String URL, String pomXpath){

        validateTrue(this.driver.findElement(usernameField));
        validateTrue(this.driver.findElement(passwordField));
        validateTrue(this.driver.findElement(signInButton));
        this.driver.findElement(usernameField).sendKeys(username);
        this.driver.findElement(passwordField).sendKeys(password);
        this.driver.findElement(signInButton).click();
        validateTrue(this.driver.findElement(signOutXpath));
        this.driver.findElement(signOutXpath);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(URL);
        validateTrue(this.driver.findElement(projectGoToFileXpath));
        this.driver.findElement(projectGoToFileXpath).click();
        validateTrue(this.driver.findElement(projectPomFIle));
        this.driver.findElement(projectPomFIle).click();
        validateTrue(this.driver.findElement(seleniumXpath));
        log.info("Version Selenium: " + driver.findElement(seleniumXpath).getText()
                .replaceAll("<version>","")
                .replaceAll("</version>","")
                .replaceAll("            ",""));
        Assert.assertEquals("3.141.59", driver.findElement(seleniumXpath).getText()
                .replaceAll("<version>","")
                .replaceAll("</version>","")
                .replaceAll("            ",""));
//add logout
        validateTrue(this.driver.findElement(profileButton));
        this.driver.findElement(profileButton).click();
        validateTrue(this.driver.findElement(signOutXpath));
        this.driver.findElement(signOutXpath).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        validateTrue(this.driver.findElement(infoAfterLogout));
        Assert.assertEquals("Built for developers", driver.findElement(infoAfterLogout).getText());
        return new LoginPage(this.driver);
    }


    public void validateError(String errorText){
        Assert.assertEquals(errorText, driver.findElement(errorMessage).getText());
    }

    private void validateTrue(WebElement element){
        log.debug("Start test for enabled true for element: " + element);
        Assert.assertTrue(element.isEnabled());
        //Assert.assertTrue(element.;
        log.debug("Test finished");
    }

}