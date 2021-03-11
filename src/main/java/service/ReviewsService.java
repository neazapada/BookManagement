package service;

import dao.BookDao;
import dao.ReviewsDao;
import model.Reviews;
import utils.UtilMethods;

import java.util.List;
import java.util.Scanner;

public class ReviewsService {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ReviewsDao reviewsDao = new ReviewsDao();

    public void createReview() {
        System.out.println("please insert the score:");
        long score = scanner.nextLong();
        System.out.println("please insert a comment:");
        String comment = scanner.next() + scanner.nextLine();
        comment = UtilMethods.firstLetterToUpperCase(comment);
        System.out.println("please insert book id :");
        Long idBook = scanner.nextLong();
        BookDao bookDao = new BookDao();

        Reviews reviews = new Reviews(score, comment, bookDao.findByIdBook(idBook));
        reviewsDao.createReviews(reviews);

    }

    public Reviews findByIdReview(Long reviewId) {
        Reviews getReview = reviewsDao.findByIdReviews(reviewId);
        if (getReview == null) {
            System.out.println(("Review with ID: " + reviewId + "does not exist"));
            return null;
        } else {
            return getReview;
        }
    }

    public void displayAllRewiews() {
        List<Reviews> reviewsList = findAllReviews();
        System.out.println("//Rewiews: \n");
        for (Reviews reviews : reviewsList) {
            System.out.println(reviews);
        }
    }

    public List<Reviews> findAllReviews() {
        return reviewsDao.displayReviews();
    }

    public void deleteReviews() {
        displayAllRewiews();
        System.out.println("Please insert review id want to delete: ");
        long idreview = scanner.nextLong();
        Reviews reviewsToDelete = findByIdReview(idreview);
        if (reviewsToDelete != null) {
            reviewsDao.deleteReviews(reviewsToDelete);
        }
    }

    public void update(Reviews reviews) {
        reviewsDao.updateReviews(reviews);
    }
}
