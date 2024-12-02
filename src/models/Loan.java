package models;

import java.time.LocalDate;

public class Loan {
    private static int loanCounter = 1;
    private int loanId;
    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(User user, Book book) {
        this.loanId = loanCounter++;
        this.user = user;
        this.book = book;
        this.loanDate = LocalDate.now();
        this.returnDate = null;
    }

    public void completeLoan() {
        this.returnDate = LocalDate.now();
        book.returnBook();
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "Loan [id=" + loanId + ", user=" + user.getName() + ", book=" + book.getTitle() +
                ", loanDate=" + loanDate + ", returnDate=" + (returnDate != null ? returnDate : "Pending") + "]";
    }
}