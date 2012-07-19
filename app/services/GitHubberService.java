package services;

import org.codehaus.jackson.JsonNode;

import java.util.LinkedList;
import java.util.List;

public class GitHubberService {
    DefaultGitRestAPIWrapper gitRest = new DefaultGitRestAPIWrapper();

    public List<String> enquery(String user, String project) {
        JsonNode json = gitRest.getGithubWatchersJson(user, project);
        return parseFollowers(json);
    }

    public void setGitRest(DefaultGitRestAPIWrapper gitRest) {
        this.gitRest = gitRest;
    }

    private List<String> parseFollowers(JsonNode json) {
        List<String> result = new LinkedList<String>();

        for (JsonNode jsonNodes : json) {
        result.add(jsonNodes.get("login").toString().replace("\"",""));
        }
        return result;
    }
}
