package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.ProjectPage;

public class PageObjectLoginTest extends BaseTest{

    private LoginPage loginPage;
    private ProjectPage projectPage;


    @Before
    public void init(){
        this.loginPage = new LoginPage(this.driver);
    }

    @Test
    public void negativeAuthTest(){
        this.loginPage.login("TestUser", "TestPassword")
                .validateError("Incorrect username or password.");
    }
    @Test
    public void positiveAuthTestMy(){
        this.loginPage.login(
                property.getProperty("myUsername"),
                System.getProperty("password"));
    }

    @Test
    public void positiveProjectPage(){

        this.loginPage.reject(
                        property.getProperty("myUsername"),
                        System.getProperty("password"),
                        property.getProperty("projectUrl"));
    }

    @Test
    public void positiveProjectPom(){
        this.loginPage.pomFile(property.getProperty("myUsername"),
                System.getProperty("password"),
                property.getProperty("projectUrl"),
                property.getProperty("projectPomFIle"));
    }

    @Test
    public void pomFileFindSelenium(){
        this.loginPage.pomFileFindSelenium(property.getProperty("myUsername"),
                System.getProperty("password"),
                property.getProperty("projectUrl"),
                property.getProperty("projectPomFIle"));
    }


    @Test
    public void SignOutProfile(){
        this.loginPage.SignOutProfile(property.getProperty("myUsername"),
                System.getProperty("password"),
                property.getProperty("projectUrl"),
                property.getProperty("projectPomFIle"));
    }


    @Test
    public void positiveAuthTest(){
        this.loginPage.login()
                .validateSuccess("Learn Git and GitHub without any code!");
    }


    @Test
    public void checkOurCommits(){
        this.loginPage.login()
                .openCommits();
    }



}
