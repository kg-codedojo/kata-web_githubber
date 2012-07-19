package services;

import org.codehaus.jackson.JsonNode;
import play.libs.F;
import play.libs.WS;
import play.mvc.Result;

public class DefaultGitRestAPIWrapper {
    public JsonNode getGithubWatchersJson(String user, String project) {
        F.Promise<WS.Response> apiGitHubWatchers = WS.url("https://api.github.com/repos/"+user+"/"+project+"/watchers").get();
        return apiGitHubWatchers.get().asJson();
    }
}
