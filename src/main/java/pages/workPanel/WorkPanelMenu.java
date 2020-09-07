package pages.workPanel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainMenu;
import pages.workPanel.code.CodePage;
import pages.workPanel.issues.IssuesPage;

public abstract class WorkPanelMenu extends MainMenu {

    public WorkPanelMenu(WebDriver driver) {
        super(driver);
    }

    private final By codeTabButton = By.xpath(property.getProperty("codeTabButton"));
    private final By issuesTabButton = By.xpath(property.getProperty("issuesTabButton"));
    private final By pullRequestsTabButton = By.xpath(property.getProperty("pullRequestsTabButton"));
    private final By actionsTabButton = By.xpath(property.getProperty("actionsTabButton"));
    private final By projectTabButton = By.xpath(property.getProperty("projectTabButton"));
    private final By wikiTabButton = By.xpath(property.getProperty("wikiTabButton"));
    private final By securityTabButton = By.xpath(property.getProperty("securityTabButton"));
    private final By insightsTabButton = By.xpath(property.getProperty("insightsTabButton"));
    private final By settingsTabButton = By.xpath(property.getProperty("settingsTabButton"));


    public IssuesPage openProjectIssues(){
        Assert.assertTrue(this.driver.findElement(issuesTabButton).isDisplayed());
        this.driver.findElement(issuesTabButton).click();
        log.info("openProjectIssues ok");
        return new IssuesPage(this.driver);
    }

    public CodePage openProjectCode(){
        Assert.assertTrue(this.driver.findElement(codeTabButton).isDisplayed());
        this.driver.findElement(codeTabButton).click();
        return new CodePage(this.driver);
    }

}
