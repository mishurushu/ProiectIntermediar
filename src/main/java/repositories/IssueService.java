package repositories;

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;

public class IssueService {

    public void addIssue(Issue issue) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(issue);
        transaction.commit();
        session.close();
    }

    public String showIssueByTitlelikeString(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String intrebare = "select i.title from Issue i where i.title like :nume";
        Query query = session.createQuery(intrebare);
        query.setParameter("nume", name);
        String issue  = (String) query.getSingleResult();
        session.close();
        return issue;
    }

    public Issue showIssueByTitle(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String intrebare = "from Issue i where i.title like : nume";
        Query query = session.createQuery(intrebare);
        query.setParameter("nume", "%" + name + "%");
        Issue issue  = (Issue) query.getSingleResult();
        session.close();
        return issue;
    }

    public Status showStatusByIssueTitle(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String intrebare = "select i.status from Issue i where i.title = :nume";
        TypedQuery<Status> query = session.createQuery(intrebare);
        query.setParameter("nume",  name);
        Status status  =  query.getSingleResult();
        session.close();
        return status;
    }


    public void editIssueByTitle(String editTitle , String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hqlUpdate = "update Issue i set i.title = :newText where i.title = :userText";
        int updatedEntities = session.createQuery( hqlUpdate )
                .setParameter("newText", editTitle)
                .setParameter("userText", title)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteIssueByTitle(String title){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete Issue i where i.title like : nume");
        q.setParameter("nume", title);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }

}
