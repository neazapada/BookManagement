package service;

import dao.BookDao;
import model.Author;
import model.Book;
import dao.AuthorDao;
import utils.UtilMethods;

import java.util.List;
import java.util.Scanner;

public class BookService {
    private static Scanner scanner = new Scanner(System.in);
    private static BookDao bookDao = new BookDao();
    private static AuthorDao authorDao = new AuthorDao();
    private static AuthorService authorService = new AuthorService();

    public void createBook() {
        System.out.println("Please insert book's title: ");
        String title = scanner.next() + scanner.nextLine();
        title = UtilMethods.firstLetterToUpperCase(title);

        System.out.println("Please insert book's description: ");
        String description = scanner.next() + scanner.nextLine();
        description = UtilMethods.firstLetterToUpperCase(description);

        Author authorFromList = selectAuthor();
        Book book = new Book(title, description, (List<Author>) authorFromList);
        bookDao.createBook(book);
    }


    public Author selectAuthor() {
        List<Author> authors = authorService.findAllAuthors();
        System.out.println("\nCurrent authors: \n");
        for (Author author : authors) {
            System.out.println(author);
        }
        System.out.println("Please select author id");
        Long authorId = scanner.nextLong();
        Author selectedAuthor = authorService.findByIdAuthor(authorId);
        if (selectedAuthor == null) {
            return selectAuthor();
        } else {
            return selectedAuthor;
        }
    }

    public Book findByIdBook(Long bookId) {
        Book getBook = bookDao.findByIdBook(bookId);
        if (getBook == null) {
            System.out.println("Book with ID: " + bookId + " does not exists!");
            return null;
        } else {
            return getBook;
        }
    }

    public void displayAllBooks() {
        List<Book> bookList = findAllBooks();
        System.out.println("\nBooks: \n");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public List<Book> findAllBooks() {
        return bookDao.displayBook();
    }

    public void deleteBook() {
        displayAllBooks();
        System.out.println("Please insert book id you want to delete:");
        long bookId = scanner.nextLong();
        Book bookToDelete = findByIdBook(bookId);
        if (bookToDelete != null) {
            bookDao.deleteBook(bookToDelete);
        }
    }

    public void update(Book book) {
        bookDao.updateBook(book);
    }
}


