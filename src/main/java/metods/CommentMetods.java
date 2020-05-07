package metods;

import model.Comment;
import model.Issue;
import model.Status;
import repositories.CommentService;
import repositories.IssueService;

public class CommentMetods {

    public void addCommentToIssue(String s , int a) {
        if(a == 4) {
            IssueService issueService = new IssueService();
            String string = issueService.showIssueByTitlelikeString(s);
            CommentService commentService = new CommentService();
            commentService.addComment(s);

        }
        }
}
