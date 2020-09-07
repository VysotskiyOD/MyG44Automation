package pages.workPanel.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.workPanel.WorkPanelMenu;

import java.util.Arrays;
import java.util.List;

public class IssueCreationPage extends WorkPanelMenu {

    public IssueCreationPage(WebDriver driver) {
        super(driver);
    }

    private final By titleField = By.id(property.getProperty("titleField"));
    private final By commentField = By.id(property.getProperty("commentField"));
    private final By additionalFieldButtons = By.xpath(property.getProperty("additionalFieldButtons"));
    private final By fieldButton = By.xpath(property.getProperty("fieldButton"));
    private final By labelSearchField = By.id(property.getProperty("labelSearchField"));
    private final By submitNewIssue = By.xpath(property.getProperty("submitNewIssue"));
    private final By issueTitle = By.xpath(property.getProperty("issueDone"));
    private final By issueComment = By.xpath(property.getProperty("issueComment"));
    private final By issuesLabels = By.xpath(property.getProperty("issuesLabels"));

    private By labelLocator(String name){
        return By.xpath(String.format("//span[text() = '%s']", name));
    }



    public IssueCreationPage createIssue(String title, String comment, List<String> labels){
        Assert.assertTrue(this.driver.findElement(titleField).isDisplayed());
        this.driver.findElement(titleField).sendKeys(title);
        this.driver.findElement(commentField).sendKeys(comment);
        this.driver.findElements(additionalFieldButtons).get(1).click();
        for(int i = 0; i < labels.size(); i++){
            Assert.assertTrue(this.driver.findElement(labelLocator(labels.get(i))).isDisplayed());
            this.driver.findElement(labelLocator(labels.get(i))).click();
        }

        this.driver.findElement(fieldButton).click();
        return new IssueCreationPage(this.driver);

    }

    public IssueCreationPage submitIssue(){
        this.driver.findElement(submitNewIssue).click();
        return new IssueCreationPage(this.driver);


    }

    public void checkIssue(String title, String comment, List<String> labels){
        Assert.assertTrue(this.driver.findElement(issueTitle).getText().contains(title));
        log.info("Title Issue "+this.driver.findElement(issueTitle).getText());
        Assert.assertTrue(this.driver.findElement(issueComment).getText().contains(comment));
        log.info("Comment Issue "+this.driver.findElement(issueComment).getText());
        List<WebElement> findElementsTabs = driver.findElements(issuesLabels);

        // this are all the tabs
        for (WebElement webElement : findElementsTabs) {
            Assert.assertTrue(Arrays.stream(labels.toArray()).anyMatch(webElement.getText()::equals));
            log.info("Label Issue "+webElement.getText()+" in param Issues "+Arrays.stream(labels.toArray()).anyMatch(webElement.getText()::equals));
        }

    }
}
