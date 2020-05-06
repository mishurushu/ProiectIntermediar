package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Type")

public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeId")
    public int typeId;

    @Column(name = "typeName")
    public String typeName;

    @OneToMany(mappedBy = "type")
    public List<Issue> issuesOnType;


    public Type(String typeName) {
        this.typeName = typeName;
    }

    public Type() {
    }


    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}