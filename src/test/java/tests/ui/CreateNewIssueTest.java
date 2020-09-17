package tests.ui;

import org.junit.Before;
import org.junit.Test;
import pages.FindProject;
import pages.LoginPage;
import pages.ProjectPage;

public class CreateNewIssueTest extends BaseTest{
    private LoginPage loginPage;
    private ProjectPage projectPage;
    private FindProject findProject;

    @Before
    public void init(){
        this.loginPage = new LoginPage(this.driver);
        this.projectPage = new ProjectPage(this.driver);
        this.findProject = new FindProject(this.driver);

    }


    @Test
    public void positiveAuthTestMy(){
        this.findProject.login(
                property.getProperty("myUsername"),
                System.getProperty("password"));
    }


    @Test
    public void positiveFind(){
        this.findProject.find(this.findProject.login(
                property.getProperty("myUsername"),
                System.getProperty("password")));
    }

    @Test
    public void positiveFindTabs(){
        this.findProject.findTabs(  this.findProject.find(
                                    this.findProject.login(
                                        property.getProperty("myUsername"),
                                            System.getProperty("password"))));
    }


    @Test
    public void createNewIssues(){
        this.findProject.createNewIssues(  this.findProject.findTabs(
                                    this.findProject.find(
                                    this.findProject.login(
                                            property.getProperty("myUsername"),
                                            System.getProperty("password")))));
    }

    @Test
    public void findIssues(){
        this.findProject.findIssues(this.findProject.createNewIssues(
                        this.findProject.findTabs(
                        this.findProject.find(
                        this.findProject.login(
                                property.getProperty("myUsername"),
                                System.getProperty("password"))))));
    }

    @Test
    public void closeUserPage(){
        this.findProject.closeUserPage(
                this.findProject.findIssues(
                this.findProject.createNewIssues(
                this.findProject.findTabs(
                        this.findProject.find(
                                this.findProject.login(
                                        property.getProperty("myUsername"),
                                        System.getProperty("password")))))));
    }



}
