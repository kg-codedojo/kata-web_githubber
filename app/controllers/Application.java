package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;

import services.GitHubberService;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {
    public static class Githubber{
        public String user;
        public String project;
    } 
  
  public static Result index() {
    return ok(index.render(new ArrayList<String>(), form(Githubber.class)));
  }
    
    public static Result getWatchers(){
        Form<Githubber> filledForm = form(Githubber.class).bindFromRequest();
        Githubber githubber = filledForm.get();
        List<String> followers = new GitHubberService().enquery(githubber.user,githubber.project);
        return ok(index.render(followers, filledForm));
    }
  
}