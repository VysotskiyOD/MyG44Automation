package tests.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected final Logger log = LogManager.getLogger("Test");

    protected WebDriver driver;
    protected FileInputStream param;
    protected Properties property = new Properties();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") +
                        "/src/main/resources/drivers/chrome/v84/chromedriver.exe");
        switch (System.getProperty("browser", "chrome")) {
            case "chrome":
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                this.driver = new FirefoxDriver();
                break;
            case "internet_explorer":
            case "ie":
            case "InternetExplorer":
                this.driver = new InternetExplorerDriver();
                break;
            default:
                this.driver = new OperaDriver();
                break;


        }

        //Properties property = new Properties();

        try {
            param = new FileInputStream("src/test/resources/app.properties");
            property.load(param);


        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(property.getProperty("baseUrl"));
    }

    @After
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.quit();
    }
}