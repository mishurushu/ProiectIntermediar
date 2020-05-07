package metods;

import model.Issue;
import model.Project;
import repositories.IssueService;
import repositories.ProjectService;

import java.util.List;
import java.util.Scanner;

public class IssueMetods {

    public void addIssueFromKeyboard(int i){
        if(i == 2){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter title, description and project name: ");
            String title;
            title = scanner.nextLine();
            String description;
            description = scanner.nextLine();
            String s = scanner.nextLine();
            ProjectMetods projectMetods = new ProjectMetods();
            Project project = projectMetods.enterInProjectWithName(s);
            Issue issue = new Issue(title,description,project);
            IssueService issueService = new IssueService();
            issueService.addIssue(issue);
        }
    }

    public Issue enterInIssue (String name){
        IssueService issueService = new IssueService();
        return issueService.showIssueByTitle(name);
    }

}
