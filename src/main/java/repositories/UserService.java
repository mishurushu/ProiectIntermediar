package repositories;

import model.HibernateUtil;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.List;

public class UserService {


    public void addUser(User userService) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userService);
        transaction.commit();
        session.close();
    }

    public User showUserByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String intrebare = "from User u where u.userName like : nume";
        Query query = session.createQuery(intrebare);
        query.setParameter("nume", "%" + name + "%");
        User users  = (User) query.getSingleResult();
        session.close();
        return users;
    }

    public List<User> showUsersLikeName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String intrebare = "from User u where u.userName like : nume";
        Query query = session.createQuery(intrebare);
        query.setParameter("nume", "%" + name + "%");
        List<User> users  = query.list();
        session.close();
        return users;

    }

    public void editUserByName(String name,  String oldName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hqlUpdate = "update User u set  u.userName = : newName" +
                " where u.userName = :oldName" ;
        int updatedEntities = session.createQuery( hqlUpdate )
                .setParameter( "newName", name)
                .setParameter("oldName",oldName)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public void deleteUserByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete User u where u.userName like : nume");
        q.setParameter("nume", name);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }

}