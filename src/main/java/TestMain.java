import metods.*;
import model.*;
import repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {

        /*Project projectTest = new Project("Facebook","Fbk","aplicatie de socializare");
         ps.addProject(projectTest);*/
        //TRANSIENT
       //Project newP = new Project("lifeCycle", "LFC", "someDescription");
       // System.out.println("ID PROJECT:" + newP.projectId);
        //Project facebook = ps.getProjectByName("Facebook");
        //facebook.identifierProject = "OMFG";
       // ps.addProject(newP);
        // PERSISTENT
       // System.out.println("ID PROJECT AFTER SAVING : " + newP.projectId);
       // ps.delete(newP);
        //System.out.println("ID PROJECT NOW AFTER DELETE:" + newP.projectId);
        // ps.addProject(project);
       // System.out.println(ps.showProjects("f"));


        //User Test
        /*User userTest = new User("Petrica Georgel");
        UserService userServiceTest = new UserService();
         userServiceTest.addUser(userTest);*/
       // System.out.println(userServiceTest.showUsersLikeName("Petrica"));
        //userTest.userName = "Andrei Popescu";
        //userServiceTest.addUser(userTest); // aici vrei sa dai edit la un user existent. pentru ca daca scrii
        // userTest.userName = "andrei popescu" iti face alt obiect vezi tabela proiecte ;
       // userServiceTest.editUserByName("Paul Gabriel","Andrei Popescu");
       // userServiceTest.deleteUser(userServiceTest.showUserByName("Petrica Georgel"));
         // userServiceTest.deleteUserByName("Petrica Georgel");


        //Status Test
        /*Status statusTest = new Status("Open");
        StatusService statusServiceTest = new StatusService();
        statusServiceTest.addStatus(statusTest);*/
        //System.out.println(statusServiceTest.showStatus("Open"));
        //statusServiceTest.editStatusByName("Done","edit Test");
        //statusServiceTest.deleteStatusByName("Open");


        //Type Test
        /*Type typeTest = new Type("addButton");
        TypeService typeService = new TypeService();
        typeService.addType(typeTest);*/
       // System.out.println(typeService.showType("add"));
        //typeService.editTypeByName("edit Test","addButton");
        //typeService.deleteTypeByName("edit Test");



        //Issue TEST
     //  Project projectTest = new Project("desters","desters","destersializare");
        //ps.addProject(projectTest);
      //  User userTest = new User("destersPetrica Georgel");
     //   UserService userServiceTest = new UserService();
        //userServiceTest.addUser(userTest);
      //  Status statusTest = new Status("destersOpen");
      //  StatusService statusServiceTest = new StatusService();
        //statusServiceTest.addStatus(statusTest);
     //   Type typeTest = new Type("destersaddButton");
        //typeService.addType(typeTest);
       // ProjectService ps = new ProjectService();
       // TypeService typeService = new TypeService();
        //IssueService issueServiceTest = new IssueService();
       // Project deStersProject = ps.getProjectByName("desters");
       // Type fixBug = typeService.showTypeByname("FixBug");
       // StatusService statusServiceTest = new StatusService();
      //  List<Status> done = statusServiceTest.showStatus("Done");
       // UserService userServiceTest = new UserService();
       // User user = userServiceTest.showUserByName("Paul Gabriel");
       // Issue issueTest = new Issue("Fix this","I want to add functionality",deStersProject,done.get(0),
             //   user,fixBug);
       //issueServiceTest.addIssue(issueTest);
       // System.out.println(issueServiceTest.showIssueByTitle("Fix this"));
         //issueServiceTest.editIssueByTitle("Best issue ever","Fix this");
       // pot sa sterg doar ce creez pe loc pentru ca altfel imi da eroarea "object references an unsaved transient instance-save the transient instance before flushing"


        //Comment TEST
       /* User userTest = new User();
        UserService userServiceTest = new UserService();
        User userForComment = userServiceTest.showUserByName("Paul Gabriel");
        Issue issueTest = new Issue();
        IssueService issueService = new IssueService();
        Issue issueForComment = issueService.showIssueByTitle("Best issue ever");
        Comment commentTest = new Comment("Nu imi place proiectul asta",userForComment,issueForComment);
        CommentService commentService = new CommentService();*/
        //commentService.addComment(commentTest);


        // Metoda Login
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String name = scanner.nextLine();
        Login login = new Login();
        login.welcome(name);
        login.whatYouWant(name);
        int i = scanner.nextInt();
        while (i != 0){
            if ( i==1 ){
                ProjectMetods projectMetods = new ProjectMetods();
                projectMetods.addProjectFromKeyboard(i);
                System.out.print("If you want to continue press 1-9 , if you want to exit press 0 ");
                i = scanner.nextInt();
            }else if (i == 2){
                IssueMetods issueMetods = new IssueMetods();
                issueMetods.addIssueFromKeyboard(i);
                System.out.print("If you want to continue press 1-9 , if you want to exit press 0 ");
                i = scanner.nextInt();
            }else if (i == 3){
                IssueMetods issueMetods = new IssueMetods();
                issueMetods.addIssueFromKeyboard(i);
                StatusMetods statusMetods = new StatusMetods();
                scanner.nextLine();
                String s = scanner.nextLine();
                statusMetods.seeIssueStatus(i,s);
                System.out.print("If you want to continue press 1-9 , if you want to exit press 0 ");
                i = scanner.nextInt();
            }else if(i == 4){
                scanner.nextLine();
                CommentMetods commentMetods = new CommentMetods();
                String comment = scanner.nextLine();
                commentMetods.addCommentToIssue(comment, i);
            }
        }

        HibernateUtil.shutdown();
    }
}
