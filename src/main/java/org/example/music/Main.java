package org.example.music;

/**
 * Каталог музыкальных треков
 *
 * Создайте класс MusicTrack с полями для названия трека,
 * исполнителя и жанра.
 * В классе MusicLibrary используйте HashMap<String, HashSet<MusicTrack>>
 * для организации музыкальных треков по жанрам, где ключом
 * является жанр, а значением - набор треков этого жанра.
 * Реализуйте методы для добавления трека в библиотеку,
 * удаления трека из библиотеки и получения всех треков заданного жанра.
 */
public class Main {
    public static void main(String[] args) {
        MusicLibrary library = new MusicLibrary();

        // Создание музыкальных треков
        MusicTrack track1 = new MusicTrack("Shape of You", "Ed Sheeran", "Pop");
        MusicTrack track2 = new MusicTrack("Believer", "Imagine Dragons", "Rock");
        MusicTrack track3 = new MusicTrack("Blinding Lights", "The Weeknd", "Pop");
        MusicTrack track4 = new MusicTrack("Thunderstruck", "AC/DC", "Rock");

        // Добавление треков в библиотеку
        library.addTrack(track1);
        library.addTrack(track2);
        library.addTrack(track3);
        library.addTrack(track4);

        // Вывод всех треков
        System.out.println("Все треки в библиотеке:");
        library.displayAllTracks();

        // Получение и вывод всех треков жанра "Pop"
        System.out.println("\nТреки жанра 'Pop':");
        for (MusicTrack track : library.getTracksByGenre("Pop")) {
            System.out.println(track);
        }

        // Удаление трека из библиотеки
        library.removeTrack(track1);

        // Вывод всех треков после удаления
        System.out.println("\nВсе треки в библиотеке после удаления:");
        library.displayAllTracks();
    }
}