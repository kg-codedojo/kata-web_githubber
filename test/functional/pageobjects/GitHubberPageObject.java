package functional.pageobjects;

import play.test.TestBrowser;

import java.util.List;

public class GitHubberPageObject {

    private TestBrowser browser;

    public List<String> followers;

    private GitHubberPageObject(TestBrowser browser) {
        this.browser = browser;
    }

    public static synchronized GitHubberPageObject at(TestBrowser browser, String url) {
        browser.goTo(url);
        return  new GitHubberPageObject(browser);
    }

    public void enterUser(String user) {
         browser.fill("input[name='user']").with(user);
    }

    public void enterProject(String project) {
        browser.fill("input[name='project']").with(project);
    }

    public void submit() {
        browser.$("input[type='submit']").click();
        followers = extractWatchers();
    }

    private List extractWatchers() {
        List<String> result = browser.$("ui").getTexts();
        return result;
    }
}
