package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    public Integer projectId;

    @Column(name = "nameProject")
    public String nameProject;

    @Column(name = "identifierProject")
    public String identifierProject;

    @Column(name = "description")
    public String description;

    @OneToMany(mappedBy = "project")
    List<Issue> issuesForProject;

    public Project(){

    }


    public Project(String nameProject, String identifierProject, String description) {
        this.nameProject = nameProject;
        this.identifierProject = identifierProject;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", nameProject='" + nameProject + '\'' +
                ", identifierProject='" + identifierProject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}