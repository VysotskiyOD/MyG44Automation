package pages.workPanel.code;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.workPanel.WorkPanelMenu;

import static java.lang.Thread.sleep;

public class CodePage extends WorkPanelMenu {

    public CodePage(WebDriver driver) {
        super(driver);
    }
    protected final Logger log = LogManager.getLogger("CodePage");

    private final By pomFileButton = By.xpath("//a[@title = 'pom.xml']");

    public POMXmlPage openPomFile(){
        log.info("Открываем файл pom.xml");
        try {
            sleep(500);
        } catch (InterruptedException e) {
            log.error(e);
        }
        Assert.assertTrue(this.driver.findElement(pomFileButton).isDisplayed());
        this.driver.findElement(pomFileButton).click();
        log.info("Кнопка видима и нажата");
        return new POMXmlPage(driver);
    }

}
