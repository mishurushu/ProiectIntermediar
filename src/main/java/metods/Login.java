package metods;

import model.User;
import repositories.UserService;

import java.util.ArrayList;
import java.util.List;

public class Login {

    public void welcome(String name){
        UserService userServiceWelcome = new UserService();
        List<String> users = userServiceWelcome.getUserNamesLikeString(name);
        if(users.contains(name)){
            System.out.println("Welcome");
        }
    }

    public void whatYouWant(String name){
        UserService userServiceWelcome = new UserService();
        List<String> users = userServiceWelcome.getUserNamesLikeString(name);
        if(users.contains(name)){
            System.out.println("If you want to add a new project press 1");
            System.out.println("If you want to add a new issue enter in your project with your identifier and after complet your issue boxes");
            System.out.println("If you want to see your status progress of a project text name of project: ");
            System.out.println("If you want to let a comment to an issue text issue title: ");
        }
    }

}
