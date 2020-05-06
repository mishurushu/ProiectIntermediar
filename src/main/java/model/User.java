package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")

public class User {

    public User() {
    }

    public User(String userName){
        this.userName= userName;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    public int userId;

    @Column(name = "userName")
    public String userName;

    @OneToMany(mappedBy = "user")
    public List<Issue> issuesOnUser;

    @OneToMany(mappedBy = "userLeftComment" )
    public List<Comment> comments;


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}