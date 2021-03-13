package utils;


import model.Author;
import model.Book;
import model.Reviews;

import java.io.*;
import java.util.*;

public class ExportCsv {

    private static final String CSV_SEPARATOR = ",";

    public void exportCsvAuthor(List<Author> authors) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("author.csv"), "UTF-8"));
            for (Author author : authors) {
                String oneLine = author.getAuthorId() +
                        CSV_SEPARATOR +
                        author.getFirstName() +
                        CSV_SEPARATOR +
                        author.getLastNAme();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Author exported list to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void exportCsvBook(List<Book> books) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("book.csv"), "UTF-8"));
            for (Book book : books) {
                String oneLine = book.getBookId() +
                        CSV_SEPARATOR +
                        book.getTitle() +
                        CSV_SEPARATOR +
                        book.getDescription();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Book list exported to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void exportCsvReviews(List<Reviews> reviewsList) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("reviews.csv"), "UTF-8"));
            for (Reviews reviews: reviewsList) {
                String oneLine = reviews.getReviewsId() +
                        CSV_SEPARATOR +
                        reviews.getScore() +
                        CSV_SEPARATOR +
                        reviews.getComment() +
                        CSV_SEPARATOR +
                        reviews.getBook().getBookId();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Reviews list exported to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

}

