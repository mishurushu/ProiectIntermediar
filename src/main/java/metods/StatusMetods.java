package metods;

import model.Status;
import repositories.IssueService;
import repositories.StatusService;

import java.util.Scanner;

public class StatusMetods {

    public Status seeIssueStatus(int a, String s) {
        Status theStatus = null;
        if (a == 3) {


            IssueService issueService = new IssueService();
            theStatus = issueService.showStatusByIssueTitle(s);
            System.out.println(theStatus);
            return theStatus;
        }
        return theStatus;
    }
}
