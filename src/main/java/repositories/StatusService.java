package repositories;

import model.HibernateUtil;
import model.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.List;

public class StatusService {



    public void addStatus(Status status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(status);
        transaction.commit();
        session.close();

    }

    public List<Status> showStatus(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String intrebare = "from  Status s where s.statusName like : nume";
        Query query = session.createQuery(intrebare);
        query.setParameter("nume", "%" + name + "%");
        List<Status> statuses = query.list();
        return statuses;

    }

    public void editStatusByName(String name, String oldName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hqlUpdate = "update Status s set  s.statusName = : newName" +
                " where s.statusName = :oldName";
        int updatedEntities = session.createQuery(hqlUpdate)
                .setParameter("newName", name)
                .setParameter("oldName", oldName)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteStatusByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete Status s where s.statusName like : nume");
        q.setParameter("nume", name);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }

}