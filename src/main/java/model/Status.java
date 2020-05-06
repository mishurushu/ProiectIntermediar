package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")

public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusID")
    public int statusId;

    @Column(name = "statusName")
    public String statusName;

    @OneToMany(mappedBy = "status")
    public List<Issue> issuesOnStatus;


    public Status() {

    }

    public Status( String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}