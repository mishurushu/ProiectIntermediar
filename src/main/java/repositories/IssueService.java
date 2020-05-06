package repositories;

import model.HibernateUtil;
import model.Issue;
import model.Type;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class IssueService {

    public void addIssue(Issue issue) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(issue);
        transaction.commit();
        session.close();
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
