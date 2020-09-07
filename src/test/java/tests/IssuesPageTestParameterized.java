package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.MainPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class IssuesPageTestParameterized extends BaseTest {

    private MainPage page;
    private final String title;
    private final String comment;
    private final List<String> labels;

    public IssuesPageTestParameterized(String title1, String comment1, List<String> labels1){
        this.title = title1;
        this.comment = comment1;
        this.labels = labels1;
    }

    @Parameterized.Parameters
    public static List<Object[]> data(){


        return Arrays.asList(new Object[][]{
                {"Test title", "Test comment", new ArrayList<String>() {{
                    add("bug");
                }}
                },
                {"Test title", "Test comment", new ArrayList<String>() {{
                add("documentation");
                }}
                },
                {"Test title", "Test comment", new ArrayList<String>() {{
                add("question");
                }}
                },
                {"Test title", "Test comment", new ArrayList<String>() {{
                    add("bug");
                    add("documentation");
                }}
                },
        {"Test title", "Test comment", new ArrayList<String>() {{
            add("bug");
            add("question");
        }}
        },
        {"Test title", "Test comment", new ArrayList<String>() {{
            add("documentation");
            add("question");
        }}
        },
        {"Test title", "Test comment", new ArrayList<String>() {{
            add("documentation");
            add("question");
            add("bug");
        }}
        }
                });
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
