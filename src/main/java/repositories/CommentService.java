package repositories;
import model.Comment;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CommentService {



    public void addComment(CommentService commentService) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(commentService);
        transaction.commit();
        session.close();
    }

    public List<Comment> showComments(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String intrebare = "from Comment c";
        Query query = session.createQuery(intrebare);
        List<Comment> comments = query.list();
        return comments;
    }

    public void editCommentByUserName(String editText , String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hqlUpdate = "update Comment c set c.commentText = :newText where c.userLeftComment.userName = :userText";
        int updatedEntities = session.createQuery( hqlUpdate )
                .setParameter("newText", editText)
                .setParameter("userText", username)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

}