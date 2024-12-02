package models;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public boolean borrowBook() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("This book is currently not available.");
        }
        isAvailable = false;
        return true;
    }

    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        }
        return false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", available=" + isAvailable + "]";
    }
}