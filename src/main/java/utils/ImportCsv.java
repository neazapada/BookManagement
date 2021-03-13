package utils;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

import com.opencsv.CSVReader;
import dao.AuthorDao;
import dao.BookDao;
import dao.ReviewsDao;
import model.Author;
import model.Book;
import model.Reviews;

import java.io.FileReader;
import java.util.Scanner;

public class ImportCsv {

    private static final Scanner scanner = new Scanner(System.in);

    public void importCsvAuthor() throws IOException, CsvValidationException {
        System.out.println("Introduceti numele fisierului daca este in acelasi director cu proiectul author.csv");
        String location = scanner.next();
        CSVReader csvReader = new CSVReader(new FileReader(location));
        String[] line;
        while ((line = csvReader.readNext()) != null) {

            AuthorDao authorDao = new AuthorDao();
            Author author = new Author();


            author.setFirstName(line[1]);
            author.setLastNAme(line[2]);
            authorDao.createAuthor(author);
        }
    }


    public void importCsvBook() throws IOException, CsvValidationException {
        System.out.println("Introduceti numele fisierului daca este in acelasi director cu proiectul vet.csv");
        String location = scanner.next();
        CSVReader csvReader = new CSVReader(new FileReader(location));
        String[] line;
        while ((line = csvReader.readNext()) != null) {

            BookDao bookDao = new BookDao();
            Book book = new Book();

            book.setTitle(line[1]);
            book.setDescription(line[2]);
            bookDao.createBook(book);
        }
    }

    public void importCsvReviews() throws IOException, CsvValidationException {
        System.out.println("Introduceti numele fisierului daca este in acelasi director cu proiectul consult.csv");
        String location = scanner.next();
        CSVReader csvReader = new CSVReader(new FileReader(location));
        String[] line;
        while ((line = csvReader.readNext()) != null) {

            ReviewsDao reviewsDao = new ReviewsDao();
            Reviews reviews = new Reviews();
            BookDao bookDao = new BookDao();

            reviews.setScore(Long.parseLong(line[1]));
            reviews.setComment(line[2]);
            reviewsDao.createReviews(reviews);
        }
    }
}



