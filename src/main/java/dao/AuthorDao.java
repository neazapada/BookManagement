package dao;

import model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;


public class AuthorDao {

    public Author findByIdAuthor(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Author author = session.find(Author.class, id);
            return author;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Author> findByNameAuthor(String firstName) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Author where firstName=:firstName", Author.class);
            query.setParameter("firstName", firstName);
            List<Author> authorList = query.list();
            return authorList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void createAuthor(Author author) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            System.out.println("Author was created: \n" + author);
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

    public void deleteAuthor(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();
            System.out.println("Author deleted!\n" + author);
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

    public void updateAuthor(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(author);
            transaction.commit();
            System.out.println("Author was updated:\n " + author);
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

    public List<Author> displayAuthor() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Author", Author.class);
            List<Author> authorList = query.list();
            return authorList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}


