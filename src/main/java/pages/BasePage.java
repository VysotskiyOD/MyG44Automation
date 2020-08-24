package pages;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BasePage {

    protected WebDriver driver;
    protected FileInputStream param;
    protected Properties property = new Properties();
    public BasePage(WebDriver driver){
        this.driver = driver;
        try {
            param = new FileInputStream("src/main/resources/pages.properties");
            property.load(param);


        } catch (
                IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }



}
