package tests.ui.issuesTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.MainPage;
import tests.ui.BaseTest;

import java.util.List;

import static helpers.ExcelHelper.readProviderDataFromExcel;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class IssuesPageTestParameterizedExcel extends BaseTest {

    private MainPage page;
    private final String title;
    private final String comment;
    private final List<String> labels;



    public IssuesPageTestParameterizedExcel(Object title1, Object comment1, List<String> labels1){
        this.title = title1.toString();
        this.comment = comment1.toString();
        this.labels = labels1;

    }

    @Parameterized.Parameters
    public static List<Object[]> data(){


        return readProviderDataFromExcel(getProperty("user.dir")
                + "/src/test/resources/data/input/test.xlsx", "Sheet2");
    }



    @Before
    public void init(){
        this.page = new LoginPage(this.driver)
                .login();
    }

    @Test
    public void checkSearch(){
        this.page.searchProject("VysotskiyOD/G44Automation")
                .openProjectIssues()
                .pressNewIssueButton()
                .createIssue(title,comment,labels)
                .submitIssue()
                .checkIssue(title,comment,labels);

    }

    @After
    public void exit(){
        this.page.logout();
    }
}
