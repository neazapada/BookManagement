package dao;

import model.Reviews;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class ReviewsDao {

    public Reviews findByIdReviews(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Reviews reviews = session.find(Reviews.class, id);
            return reviews;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void createReviews(Reviews reviews) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(reviews);
            transaction.commit();
            System.out.println("Reviews was created:\n" + reviews);
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            System.out.println("Something went wrong!");
        } finally {
            session.close();
        }
    }

    public void deleteReviews(Reviews reviews) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(reviews);
            transaction.commit();
            System.out.println("Reviews was deleted:\n" + reviews);
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            System.out.println("Something went wrong!");
        } finally {
            session.close();
        }
    }

    public void updateReviews(Reviews reviews) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(reviews);
            transaction.commit();
            System.out.println("Reviews was updated:\n" + reviews);
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            System.out.println("Something went wrong!");
        } finally {
            session.close();
        }
    }

    public List<Reviews> displayReviews() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Reviews", Reviews.class);
            List<Reviews> reviewsList = query.list();
            return reviewsList;
        } catch (Exception ex) {
            System.out.println("lalala");
            ex.printStackTrace();
            return null;
        }
    }
}