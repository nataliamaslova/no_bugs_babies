package org.example.book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setAuthor("Dostoyevskyi");
        book.setName("Idiot");
        book.setYear(2015);
        book.display();
    }
}
