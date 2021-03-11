package service;

import dao.AuthorDao;
import model.Author;
import utils.UtilMethods;

import java.util.List;
import java.util.Scanner;

public class AuthorService {

    private static final Scanner scanner = new Scanner(System.in);
    private static final AuthorDao authorDao = new AuthorDao();

    public void createAuthor() {
        System.out.println("Please insert author's first name:");
        String firstname = scanner.next() + scanner.nextLine();
        firstname = UtilMethods.firstLetterToUpperCase(firstname);
        System.out.println("Please insert author's last name:");
        String lastName = scanner.next() + scanner.nextLine();
        lastName = UtilMethods.firstLetterToUpperCase(lastName);

        Author author = new Author(lastName, firstname);
        authorDao.createAuthor(author);

    }

    public Author findByIdAuthor(Long authorId) {
        Author getAuthor = authorDao.findByIdAuthor(authorId);
        if (getAuthor == null) {
            System.out.println("Author with ID: " + authorId + " does not exists!");
            return null;
        } else {
            return getAuthor;
        }
    }

    public void displayAllAuthors() {
        List<Author> authorList = findAllAuthors();
        System.out.println("\nAuthors: \n");
        for (Author author : authorList) {
            System.out.println(author);
        }
    }

    public List<Author> findAllAuthors() {
        return authorDao.displayAuthor();
    }

    public void deleteAuthor() {
        displayAllAuthors();
        System.out.println("Please insert author id you want to delete:");
        long idAuthor = scanner.nextLong();
        Author authorToDelete = findByIdAuthor(idAuthor);
        if (authorToDelete != null) {
            authorDao.deleteAuthor(authorToDelete);
        }
    }

    public void update(Author author) {
        authorDao.updateAuthor(author);
    }
}
