package model;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ReviewsId;

    @Column(name = "score")
    private Long score;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Reviews(){}

    public Reviews(Long score, String comment, Book book) {
        this.score = score;
        this.comment = comment;
        this.book = book;
    }

    public Long getReviewsId() {
        return ReviewsId;
    }

    public void setReviewsId(Long reviewsId) {
        ReviewsId = reviewsId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "ReviewsId=" + ReviewsId +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", book=" + book +
                '}';
    }
}

