package org.example.bookset;

import java.util.HashSet;

public class BookCollection {
    private HashSet<Book> books;

    public BookCollection() {
        this.books = new HashSet<>();
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public void add(Book book) {
        books.add(book);
    }

    public void remove(Book book) {
        books.remove(book);
    }

    public boolean contains(Book book) {
        return books.contains(book);
    }
}
