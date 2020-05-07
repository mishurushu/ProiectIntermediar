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
        }else {
            System.out.println("Sorry wrong username");

        }
    }

    public void whatYouWant(String name){
        UserService userServiceWelcome = new UserService();
        List<String> users = userServiceWelcome.getUserNamesLikeString(name);
        if(users.contains(name)){
            System.out.println("If you want to add a new project press 1");
            System.out.println("If you want to add a new issue enter in your project name and after complete your issue boxes");
            System.out.println("If you want to see your status progress of an issue press 3 and after complete issue name ");
            System.out.println("If you want to let a comment to an issue ,text issue title: ");
            System.out.println("If you want to exit press 0 ");
        }
    }

}
