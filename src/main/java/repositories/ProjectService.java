package repositories;

import model.HibernateUtil;
import model.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.List;


public class ProjectService {



    public void addProject(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(project);
        transaction.commit();
        session.close();
    }

    public void delete(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(project);
        transaction.commit();
        session.close();
    }
        // 5 =>  21 (234,234,234,24,234,234), 45 (), 67 ()
    public List<Project> getProjectsLikeName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String intrebare = "from Project p where p.nameProject like : nume";
        Query query = session.createQuery(intrebare);
        query.setParameter("nume","%" + name + "%");
        List<Project> projects = query.list();
        return projects;
    }

    public Project getProjectByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "from Project p where p.nameProject = :nume";
        TypedQuery<Project> query = session.createQuery(queryString);
        query.setParameter("nume",name);
        Project project = query.getSingleResult();
        session.close();
        return project;
    }

    public List<String> getProjectByIdentifierLikeString(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "select p.identifierProject from Project p where p.identifierProject = :nume";
        TypedQuery<String> query = session.createQuery(queryString);
        query.setParameter("nume","%" + name + "%");
        List<String> project = query.getResultList();
        session.close();
        return project;
    }

    public void editProjectByName(String name, String identifierProject, String description, String oldName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hqlUpdate = "update Project p set  p.nameProject = : newName,p.identifierProject= :newIdentifier," +
                " p.description= :newDescription where p.nameProject = :oldName" ;
        int updatedEntities = session.createQuery( hqlUpdate )
                .setParameter( "newName", name)
                .setParameter("newIdentifier", identifierProject)
                .setParameter("newDescription",description)
                .setParameter("oldName",oldName)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteProjectByName(String nameProject){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete Project p where p.nameProject like : nume");
        q.setParameter("nume", nameProject);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }


}