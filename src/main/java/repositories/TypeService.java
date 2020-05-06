package repositories;

import model.HibernateUtil;
import model.Type;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.List;
public class TypeService {



    public void addType(Type typeService) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(typeService);
        transaction.commit();
        session.close();
    }

    public List<Type> showType(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String intrebare = "from Type t where t.typeName like : nume";
        Query query = session.createQuery(intrebare);
        query.setParameter("nume", "%" + name + "%");
        List<Type> types = query.list();
        return types;

    }

    public Type showTypeByname(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String intrebare = "from Type t where t.typeName = :nume";
        TypedQuery<Type> query = session.createQuery(intrebare);
        query.setParameter("nume", name);
        Type types = query.getSingleResult();
        return types;

    }

    public void editTypeByName(String name,  String oldName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hqlUpdate = "update Type t set  t.typeName = : newName" +
                " where t.typeName = :oldName" ;
        int updatedEntities = session.createQuery( hqlUpdate )
                .setParameter( "newName", name)
                .setParameter("oldName",oldName)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteTypeByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete Type t where t.typeName like : nume");
        q.setParameter("nume", name);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }

}