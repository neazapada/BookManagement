package menu;

import com.opencsv.exceptions.CsvValidationException;
import dao.AuthorDao;
import model.Author;
import model.Book;
import model.Reviews;
import service.AuthorService;
import service.BookService;
import service.ReviewsService;
import utils.ExportCsv;
import utils.ImportCsv;
import utils.UtilMethods;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static final ExportCsv exportCSV = new ExportCsv();
    public static final ImportCsv importCSV = new ImportCsv();
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookService bookService = new BookService();
    private static final AuthorService authorService = new AuthorService();
    private static final ReviewsService reviewsService = new ReviewsService();
    private static final AuthorDao authorDao = new AuthorDao();

    public Menu() {
        showMenu();
    }

    public static void showMenu() {
        System.out.println("\nMenu ");
        System.out.println("\n0 - Exit\n1 - Create\n2 - Update\n3 - Delete\n4 - Find\n5 - Import/Export Database");
        System.out.println("Enter your choice: ");

        int option = scanner.nextInt();
        showOption(option);
    }

    public static void showOption(int option) {
        switch (option) {
            case 0:
                System.exit(0);
                break;
            case 1:
                create();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            case 4:
                find();
                break;
            case 5:

        }
    }

    public static void create() {
        System.out.println("\nCreate Menu:\n0 - Exit\n1 - Create Author\n2 - Create Book\n3 - Create Reviews\n4 - Return to Main Menu");
        System.out.println("Enter your choice: ");
        int createOption = scanner.nextInt();
        switch (createOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                createAuthor();
                showMenu();
                break;
            case 2:
                createBook();
                showMenu();
                break;
            case 3:
                createReviews();
                showMenu();
                break;
            case 4:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }

    }

    public static void update() {
        System.out.println("\nUpdate Menu\n0 - Exit\n1 - Update Author\n2 - Update Book\n3 - Update Reviews\n4 - Return to Main Menu");
        System.out.println("Enter your choice: ");
        int updateOption = scanner.nextInt();

        switch (updateOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                updateAuthor();
                showMenu();
                break;
            case 2:
                updateBook();
                showMenu();
                break;
            case 3:
                updateReviews();
                showMenu();
                break;
            case 4:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void delete() {
        System.out.println("\nDelete Menu\n0 - Exit\n1 - Delete Author\n2 - Delete Book\n3 - Delete Reviews\n4 - Return to Main Menu");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int deleteOptions = scanner.nextInt();

        switch (deleteOptions) {
            case 0:
                System.exit(0);
                break;
            case 1:
                deleteAuthor();
                showMenu();
                break;
            case 2:
                deleteBook();
                showMenu();
                break;
            case 3:
                deleteReviews();
                showMenu();
                break;
            case 4:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void find() {
        System.out.println("\nFind Menu \n0 - Exit \n1 - Find Author by id\n2 - Find Author by Name\n3 - Find Book by id\n4 - Find Reviews by id\n5 - Return to Main Menu");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int findOption = scanner.nextInt();

        switch (findOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                findAuthorById();
                showMenu();
                break;
            case 2:
                findAuthorByName();
                showMenu();
                break;
            case 3:
                findBookById();
                showMenu();
                break;
            case 4:
                findReviewsById();
                showMenu();
                break;
            case 5:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    private static void createAuthor() {
        authorService.createAuthor();
    }

    private static void createBook() {
        bookService.createBook();
    }

    private static void createReviews() {
        reviewsService.createReview();
    }


    private static void updateAuthor() {
        authorService.displayAllAuthors();
        System.out.println("\nPlease insert author id you want to update:");
        Long idAuthor = scanner.nextLong();
        Author author = authorService.findByIdAuthor(idAuthor);
        if (author == null) {
            updateAuthor();
        } else {
            updateAuthorMenu(author);
        }
    }

    private static void updateAuthorMenu(Author author) {
        System.out.println("\nUpdate Author Menu\n0 - Exit\n1 - Update firstName\n2 - Update lastName\n3 - Save and Return to Main Menu");
        System.out.println("\t Enter your choice: ");
        int updateAuthor = scanner.nextInt();

        switch (updateAuthor) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Please insert author firstName");
                String authorFirstName = UtilMethods.firstLetterToUpperCase(scanner.next());
                author.setFirstName(authorFirstName);
                updateAuthorMenu(author);
                break;
            case 2:
                System.out.println("Please insert author lastName");
                String authorLastName = UtilMethods.firstLetterToUpperCase(scanner.next());
                author.setLastNAme(scanner.next());
                updateAuthorMenu(author);
                break;
            case 3:
                authorService.update(author);
                showMenu();
                break;
            default:
                System.exit(0);
        }
    }

    private static void updateBook() {
        bookService.displayAllBooks();
        System.out.println("\nPlease insert book id you want to update:");
        Long idBook = scanner.nextLong();
        Book book = bookService.findByIdBook(idBook);
        if (book == null) {
            updateBook();
        } else {
            updateBookMenu(book);
        }
    }

    private static void updateBookMenu(Book book) {
        System.out.println("\nUpdate Book Menu\n0 - Exit\n1 - Update Title\n2 - Update Description\n4 - Update Pet\n5 - Save and return to Main Menu");
        System.out.println(" Enter your choice: ");
        int updateConsult = scanner.nextInt();
        switch (updateConsult) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Please insert book  title");
                book.setTitle(scanner.next());
                updateBookMenu(book);
                break;
            case 2:
                System.out.println("Please insert book description");
                book.setDescription(scanner.next());
                updateBookMenu(book);
                break;
            case 3:
                bookService.update(book);
                showMenu();
                break;
            default:
                System.exit(0);
        }
    }

    private static void updateReviews() {
        reviewsService.displayAllRewiews();
        System.out.println("\nPlease insert reviews id you want to update:");
        Long idReviews = scanner.nextLong();
        Reviews reviews = reviewsService.findByIdReview(idReviews);
        if (reviews == null) {
            updateReviews();
        } else {
            updateReviewsMenu(reviews);
        }
    }

    private static void updateReviewsMenu(Reviews reviews) {
        System.out.println("\nUpdate Reviews Menu\n0 - Exit\n1 - Update score\n2 - Update description\n3 - Return to Main Menu");
        System.out.println(" Enter your choice: ");
        int updateReviews = scanner.nextInt();
        switch (updateReviews) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Please insert reviews score :\n");
                reviews.setScore(scanner.nextLong());
                updateReviewsMenu(reviews);
                break;
            case 2:
                System.out.println("Please insert owner description:\n");
                String description = UtilMethods.firstLetterToUpperCase(scanner.next());
                reviews.setComment(description);
                updateReviewsMenu(reviews);
                break;
            case 3:
                reviewsService.update(reviews);
                showMenu();
                break;
            default:
                System.exit(0);
        }
    }


    private static void deleteAuthor() {
        authorService.deleteAuthor();
    }

    private static void deleteBook() {
        bookService.deleteBook();
    }

    private static void deleteReviews() {
        reviewsService.deleteReviews();
    }

    private static void findAuthorById() {
        System.out.println("Please insert author id you want to select!");
        long idAuthor = scanner.nextLong();
        Author author = authorService.findByIdAuthor(idAuthor);
        if (author == null) {
            findAuthorById();
        } else {
            System.out.println(author);
        }
    }

    private static void findAuthorByName() {
        System.out.println("Please insert author first name you want to select!");
        String firstName = scanner.next();
        List<Author> authors = authorDao.findByNameAuthor(firstName);
        if (authors.isEmpty()) {
            System.out.println("Author with name: " + firstName + " does not exists!");
            findAuthorByName();
        } else {
            System.out.println(authors);
        }
    }

    private static void findBookById() {
        System.out.println("Please insert book id you want to select!");
        long idBook = scanner.nextLong();
        Book book = bookService.findByIdBook(idBook);
        if (book == null) {
            findBookById();
        } else {
            System.out.println(book);
        }
    }

    private static void findReviewsById() {
        System.out.println("Please insert Reviews id you want to select!");
        long idReviews = scanner.nextLong();
        Reviews reviews = reviewsService.findByIdReview(idReviews);
        if (reviews == null) {
            findReviewsById();
        } else {
            System.out.println(reviews);
        }
    }

    public static void importExport() throws IOException, CsvValidationException {

        System.out.println("\nImport/Export Menu:\n0 - Exit\n1 - Import CSV file\n2 - Export CSV file\n3 - Return to Main Menu");
        System.out.println("Enter your choice: ");

        int createOption = scanner.nextInt();

        switch (createOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                importFromCsv();
                showMenu();
                break;
            case 2:
                exportToCsv();
                showMenu();
                break;
            case 3:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    private static void importFromCsv() throws IOException, CsvValidationException {
        System.out.println("\nImport Menu:\n0 - Exit\n1 - Import Author\n2 - Import Book\n3 - Import Reviews\n4 - Return to Main Menu");
        System.out.println("Enter your choice: ");

        int createOption = scanner.nextInt();

        switch (createOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                importAuthor();
                break;
            case 2:
                importBook();
                break;
            case 3:
                importReviews();
                break;
            case 4:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    private static void exportToCsv() {
        System.out.println("\nExport Menu:\n0 - Exit\n1 - Export Author\n2 - Export Book\n3 - Export Review\n4 - Return to Main Menu");
        System.out.println("Enter your choice: ");

        int createOption = scanner.nextInt();

        switch (createOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                exportAuthor();
                break;
            case 2:
                exportBook();
                break;
            case 3:
                exportReviews();
                break;
            case 4:
                showMenu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void exportAuthor() {
        exportCSV.exportCsvAuthor(authorService.findAllAuthors());
    }

    public static void exportBook() {
        exportCSV.exportCsvBook(bookService.findAllBooks());
    }

    public static void exportReviews() {
        exportCSV.exportCsvReviews(reviewsService.findAllReviews());
    }

    private static void importAuthor() throws IOException, CsvValidationException {
        importCSV.importCsvAuthor();
    }

    private static void importBook() throws IOException, CsvValidationException {
        importCSV.importCsvBook();
    }

    private static void importReviews() throws IOException, CsvValidationException {
        importCSV.importCsvReviews();
    }
}















