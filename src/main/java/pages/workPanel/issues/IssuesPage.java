package pages.workPanel.issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.workPanel.WorkPanelMenu;

public class IssuesPage extends WorkPanelMenu {
    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    private final By newIssueButton = By.xpath(property.getProperty("newIssueButton"));
    private final By issueTitlesList = By.xpath(property.getProperty("issueTitlesList"));

    public IssueCreationPage pressNewIssueButton(){
        this.driver.findElement(newIssueButton).click();
        log.info("pressNewIssueButton ok");
        return new IssueCreationPage(this.driver);
    }

}
