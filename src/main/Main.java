package main;

import models.*;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1, "The Hobbit", "J.R.R. Tolkien");
        Book book2 = new Book(2, "1984", "George Orwell");

        User user = new User(1, "Jane Smith", "20230001");

        System.out.println("Usuário pegando emprestado 'The Hobbit': " + user.borrowBook(book1));
        System.out.println("Usuário pegando emprestado '1984': " + user.borrowBook(book2));

        System.out.println("\nEmpréstimos ativos:");
        user.getActiveLoans().forEach(System.out::println);

        System.out.println("\nUsuário devolvendo 'The Hobbit'");
        user.returnBook(book1);

        System.out.println("\nEmpréstimos após devolução:");
        user.getActiveLoans().forEach(System.out::println);

        System.out.println("\nLivros completos pelo usuário:");
        user.getCompletedBooks().forEach(book -> System.out.println(book.getTitle()));
    }
}