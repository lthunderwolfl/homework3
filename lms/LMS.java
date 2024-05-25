package lms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LMS {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public boolean borrowBook(Book book, Student student) {
        if (books.contains(book) && book.isAvailable()) {
            book.setAvailable(false);
            book.setBorrowedBy(student);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (books.contains(book) && !book.isAvailable()) {
            book.setAvailable(true);
            book.setBorrowedBy(null);
            return true;
        }
        return false;
    }

    public void saveState(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean loadState(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            books = (List<Book>) ois.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Book> getBooks() {
        return books;
    }
}
