package unit.views;

import controllers.Application;
import org.junit.Test;
import play.data.Form;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.fest.assertions.Assertions.assertThat;

public class IndexTest {
    @Test public void testIndex(){
        String pageSource = views.html.index.render(Arrays.asList("user1","user2","user3"), new Form(Application.Githubber.class)).body();
        assertThat(pageSource).contains("user1").contains("user2").contains("user3");
    }

    @Test public void check_vidgets_are_present(){          //, githubberForm:Form[Githubber]
        String pageSource = views.html.index.render(Arrays.asList("user1","user2","user3"), new Form(Application.Githubber.class)).body();
        assertThat(pageSource).contains("name=\"user\"").contains("name=\"project\"").contains("input type=\"submit\"");
    }
}
