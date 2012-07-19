package integration;

import org.junit.Test;
import services.GitHubberService;

import static org.fest.assertions.Assertions.assertThat;

public class GitHubberServiceIntegrationTest {


    @Test public void assert_that_konstantings_todolist_kata_has_semenodm_follower(){
        GitHubberService githubberService = new GitHubberService();
        assertThat(githubberService.enquery("konstanting", "todolist-kata").size()).isEqualTo(2);
        assertThat(githubberService.enquery("konstanting", "todolist-kata")).contains("semenodm");
    }

    @Test public void assert_that_user_olegz_with_project_s12gxDOT2011_has_18_followers_and_contains_wiwoo_bivas_smougenot_followers(){
        GitHubberService githubberService = new GitHubberService();
        assertThat(githubberService.enquery("olegz", "s12gx.2011").size()).isEqualTo(18);
        assertThat(githubberService.enquery("olegz", "s12gx.2011")).contains("wiwoo").contains("bivas").contains("smougenot");
    }
}
