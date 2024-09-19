package org.example.bookset;

/**
 * Уникальный набор книг
 *
 * Создайте класс Book с полями для названия и автора.
 * В классе BookCollection используйте HashSet<Book> для
 * хранения коллекции книг без дубликатов.
 * Реализуйте методы добавления книги в коллекцию, удаления
 * книги из коллекции и проверки, содержится ли книга в коллекции.
 */
public class Main {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection();
        Book book1 = new Book("Idiot", "Dostoyevskiy");
        Book book2 = new Book("Yevgeniy Onyegin", "Pushkin");
        Book book3 = new Book("Vishnyevyi sad", "Chehov");

        bookCollection.add(book1);
        bookCollection.add(book2);
        bookCollection.add(book3);
        bookCollection.add(book2);
        System.out.println(bookCollection.getBooks());

        bookCollection.remove(book1);
        System.out.println(bookCollection.getBooks());

        System.out.println(book1 + ": " + bookCollection.contains(book1));

        System.out.println(book2 + ": " + bookCollection.contains(book2));
    }
}
