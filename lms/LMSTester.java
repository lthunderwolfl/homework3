package lms;

public class LMSTester {
    public static void main(String[] args) {
        LMS iliauniLibrary = new LMS();

        Book lor = new Book("Lord of the Rings", "Tolkien");
        Book oop = new Book("OOP", "Paata Gogisvhili");
        iliauniLibrary.addBook(lor);
        iliauniLibrary.addBook(oop);

        Student gocha = new Student("Gocha", "Gegeshidze", "dfasdf");
        iliauniLibrary.borrowBook(lor, gocha);

        Student maka = new Student("Maka", "Lobjanidze", "3421325");
        iliauniLibrary.borrowBook(oop, maka);

        iliauniLibrary.saveState("libraryState.ser");

        // Load the state and verify
        LMS loadedLibrary = new LMS();
        loadedLibrary.loadState("libraryState.ser");

        for (Book book : loadedLibrary.getBooks()) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Available: " + book.isAvailable() +
                    ", Borrowed by: " + (book.getBorrowedBy() != null ? book.getBorrowedBy().getName() : "None"));
        }
    }
}
