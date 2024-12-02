package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String registrationNumber;
    private List<Loan> activeLoans;
    private List<Book> completedBooks;

    public User(int id, String name, String registrationNumber) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.activeLoans = new ArrayList<>();
        this.completedBooks = new ArrayList<>();
    }
    

    public boolean borrowBook(Book book) {
        try {
            if (book.borrowBook()) {
                activeLoans.add(new Loan(this, book));
                return true;
            }
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void returnBook(Book book) {
        activeLoans.stream()
                .filter(loan -> loan.getBook().equals(book) && loan.getReturnDate() == null)
                .findFirst()
                .ifPresent(loan -> {
                    loan.completeLoan();
                    completedBooks.add(book);
                });
    }

    public List<Loan> getActiveLoans() {
        return activeLoans;
    }

    public List<Book> getCompletedBooks() {
        return completedBooks;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", registrationNumber=" + registrationNumber + "]";
    }
}