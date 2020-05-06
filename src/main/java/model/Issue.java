package model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "issue")

public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issueId")
    public int issueId;

    @Column(name = "title")
    public String title;

    @Column(name = "description")
    public String description;

    @ManyToOne
    @JoinColumn(name = "projectId")
    public Project project;

    @Column(name = "dateCreated")
    public LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name = "statusId")
    public Status status;

    @ManyToOne
    @JoinColumn(name = "submitterId")
    public User user;

    @ManyToOne
    @JoinColumn(name = "typeId")
    public Type type;

    @OneToMany(mappedBy = "issueWhereLeftComm")
    public List<Comment> comment;

    public Issue() {
    }

    public Issue(String title ,String description,Project project,Status status,User user,Type type,
                 List<Comment> comments){
        this.title = title;
        this.description = description;
        this.project = project;
        this.dateCreated = LocalDateTime.now();
        this.status = status;
        this.user = user;
        this.type = type;
        this.comment = comments;
    }

    public Issue(String title ,String description,Project project,Status status,User user,Type type){
        this.title = title;
        this.description = description;
        this.project = project;
        this.dateCreated = LocalDateTime.now();
        this.status = status;
        this.user = user;
        this.type = type;
    }


    public Issue(String title ,String description,Project project,Type type){
        this.title = title;
        this.description = description;
        this.project = project;
        this.dateCreated = LocalDateTime.now();
        this.type = type;
    }

    public Issue(String title ,String description,Project project) {
        this.title = title;
        this.description = description;
        this.project = project;
        this.dateCreated = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", project=" + project +
                ", dateCreated=" + dateCreated +
                ", status=" + status +
                ", user=" + user +
                ", type=" + type +
                '}';
    }
}