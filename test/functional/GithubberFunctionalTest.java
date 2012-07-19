package functional;

import functional.pageobjects.GitHubberPageObject;
import org.junit.Test;
import play.libs.F;
import play.test.TestBrowser;

import static org.fest.assertions.Assertions.*;
import static play.test.FakeApplication.*;
import static play.test.Helpers.*;

public class GithubberFunctionalTest {
    /**
     * US: ???????????????Github????????????????????????????????????Github????????????????????
     *
     */
    @Test public void asGithubUserIWantGetListOfFollowersForGithubUserAndProject(){
        running(testServer(3333),HTMLUNIT,new F.Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) throws Throwable {
                GitHubberPageObject gitHubberPageObject = GitHubberPageObject.at(browser,"http://localhost:3333");
                gitHubberPageObject.enterUser("konstanting");
                gitHubberPageObject.enterProject("todolist-kata");
                gitHubberPageObject.submit();
                assertThat(gitHubberPageObject.followers.size()).isEqualTo(1);
                assertThat(gitHubberPageObject.followers.get(0)).isEqualTo("semenodm");
            }
        });

    }
}
