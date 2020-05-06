package model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")

public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    public int commentId;

    @Column(name = "commentText")
    public String commentText;

    @Column(name = "dateTimeCreated")
    public LocalDateTime dateTimeCreated;

    @ManyToOne
    @JoinColumn(name = "submitterId")
    public User userLeftComment;

    @ManyToOne
    @JoinColumn(name = "issueId")
    public Issue issueWhereLeftComm;

    public Comment() {
    }

    public Comment(String commentText, User submitterId, Issue issueId){
        this.commentText = commentText;
        this.dateTimeCreated = LocalDateTime.now();
        this.userLeftComment = submitterId;
        this.issueWhereLeftComm = issueId;
    }

}