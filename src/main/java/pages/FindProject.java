package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindProject extends BasePage{
    private ProjectPage projectPage;
    protected final Logger log = LogManager.getLogger("Login Page");

    private final By usernameField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By errorMessage = By.xpath("//div[@class = 'container-lg px-2']");
    private final By signOutXpath=By.xpath(property.getProperty("signOutXpath"));
    private final By projectGoToFileXpath = By.xpath(property.getProperty("projectGoToFileXpath"));
    private final By search = By.xpath(property.getProperty("search"));
    private final By searchResult = By.xpath(property.getProperty("searchResult"));
    private final By repositoryTabs = By.xpath(property.getProperty("repositoryTabs"));
    private final By newIssuesButton = By.xpath(property.getProperty("newIssuesButton"));
    private final By issueTitle = By.xpath(property.getProperty("issueTitle"));
    private final By submitNewIssue = By.xpath(property.getProperty("submitNewIssue"));
    private final By issueDone = By.xpath(property.getProperty("issueDone"));
    private final By profileButton = By.xpath(property.getProperty("profileButton"));

    public FindProject(WebDriver driver){
        super(driver);
    }

    String MyURL;
    String IssuesUrl;
// validate element
    private void validateTrue(WebElement element) {
        log.debug("Start test for enabled true for element: " + element);
        Assert.assertTrue(element.isEnabled());
        log.debug("Test finished");
    }
//login in git hub
    public FindProject login(String username, String password) {
        validateTrue(this.driver.findElement(usernameField));
        validateTrue(this.driver.findElement(passwordField));
        validateTrue(this.driver.findElement(signInButton));
        this.driver.findElement(usernameField).sendKeys(username);
        this.driver.findElement(passwordField).sendKeys(password);
        System.out.println(username+" "+password);
        this.driver.findElement(signInButton).click();
        //validateTrue(this.driver.findElement(signOutXpath));
        //this.driver.findElement(signOutXpath);
        return this;
    }

//find in search field
    public FindProject find(FindProject login){

        validateTrue(this.driver.findElement(search));
        this.driver.findElement(search).sendKeys("G44Automation\n");

        List<WebElement> findElements = driver.findElements(searchResult);

        // this are all the links you like to visit
        for (WebElement webElement : findElements)
        {
            if (webElement.getAttribute("href").contains("VysotskiyOD")) {
                log.debug(webElement.getAttribute("href"));
                MyURL=webElement.getAttribute("href");
               }
            else {log.debug(webElement.getAttribute("href"));}

        }
        log.info("Open my home url " + MyURL);
        driver.get(MyURL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return this;
    }
//find tabs in home project page
    public FindProject findTabs(FindProject find){

        validateTrue(this.driver.findElement(repositoryTabs));
        List<WebElement> findElementsTabs = driver.findElements(repositoryTabs);

        // this are all the tabs
        for (WebElement webElement : findElementsTabs) {
            if (webElement.getAttribute("data-tab-item").contains("issues")) {
                log.debug("Tabs "+webElement.getAttribute("data-tab-item"));
                IssuesUrl=webElement.getAttribute("href");
            }
            else {log.debug("Tabs "+webElement.getAttribute("data-tab-item"));}

        }
        log.info("Open my home issues url " + IssuesUrl);
        driver.get(IssuesUrl);
        validateTrue(this.driver.findElement(newIssuesButton));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return this;
    }
//create new Issue
    public FindProject createNewIssues(FindProject findTabs){

        validateTrue(this.driver.findElement(newIssuesButton));
        this.driver.findElement(newIssuesButton).click();
        validateTrue(this.driver.findElement(issueTitle));
        this.driver.findElement(issueTitle).sendKeys("TEST\n");
        return this;
    }
// title issue
    public FindProject findIssues(FindProject createNewIssues){

        validateTrue(this.driver.findElement(issueDone));
        Assert.assertTrue(this.driver.findElement(issueDone).getText().contains("TEST"));

            log.debug("Issues Title "+this.driver.findElement(issueDone).getText());
        return this;
        }

//exit
    public FindProject closeUserPage(FindProject findIssues){

        validateTrue(this.driver.findElement(profileButton));
        this.driver.findElement(profileButton).click();
        validateTrue(this.driver.findElement(signOutXpath));
        this.driver.findElement(signOutXpath).click();
        return this;
    }



}
