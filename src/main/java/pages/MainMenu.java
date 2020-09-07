package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.workPanel.issues.IssuesPage;
import pages.workPanel.code.CodePage;


import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public abstract class MainMenu extends BasePage{

    private final By searchField= By.xpath(property.getProperty("search"));
    private final By issuesButton = By.xpath(property.getProperty("issuesButton"));
    private final By searchResultList = By.xpath(property.getProperty("searchResultList"));
    private final By profileButton = By.xpath(property.getProperty("profileButton"));
    private final By signOutXpath=By.xpath(property.getProperty("signOutXpath"));

    public MainMenu(WebDriver driver) {
        super(driver);
    }
    protected final Logger log = LogManager.getLogger("MainMenu");

    public CodePage searchProject(final String projectTitle){
        log.info("Ищем проект "+ projectTitle);
        assertTrue(this.driver.findElement(searchField).isEnabled());
        this.driver.findElement(searchField).sendKeys(projectTitle);
        this.driver.findElement(searchField).click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            log.error(e);
        }
        List<WebElement> results = this.driver.findElements(searchResultList);
        results.stream()
                .filter(result -> result.getAttribute("href").contains(projectTitle))
                .findFirst()
                .orElse(results.get(2))
                .click();
        log.info(String.format("Проект %s найден", projectTitle));
        return new CodePage(this.driver);
    }

    public IssuesPage openIssues(){
        this.driver.findElement(issuesButton).click();
        return new IssuesPage(this.driver);
    }

    public HomePage logout(){
        log.info("Выход из приложения");
        //   this.driver.navigate().refresh();
        //validateTrue(this.driver.findElement(profileButton));
        this.driver.findElement(profileButton).click();
        //validateTrue(this.driver.findElement(signOutXpath));
        this.driver.findElement(signOutXpath).click();
        return new HomePage(driver);
    }
}
