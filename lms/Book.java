package lms;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private boolean available;
    private Student borrowedBy;

    public Book() {
        this.available = true;
        this.borrowedBy = null;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
        this.borrowedBy = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Student getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Student borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}
