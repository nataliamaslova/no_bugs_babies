package org.example.music;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MusicLibrary {
    private HashMap<String, HashSet<MusicTrack>> library;

    public MusicLibrary() {
        library = new HashMap<String, HashSet<MusicTrack>>();
    }

    public HashMap<String, HashSet<MusicTrack>> getLibrary() {
        return library;
    }

    public void addTrack(MusicTrack track) {
        library.putIfAbsent(track.getGenre(), new HashSet<>());
        library.get(track.getGenre()).add(track);
    }

    public void removeTrack(MusicTrack track) {
        if (library.containsKey(track.getGenre())) {
            library.get(track.getGenre()).remove(track);
            if (library.get(track.getGenre()).isEmpty()) {
                library.remove(track.getGenre());
            }
        }
    }

    // Метод для получения всех треков заданного жанра
    public Set<MusicTrack> getTracksByGenre(String genre) {
        return library.getOrDefault(genre, new HashSet<>());
    }

    // Метод для вывода всех треков
    public void displayAllTracks() {
        for (Map.Entry<String, HashSet<MusicTrack>> entry : library.entrySet()) {
            System.out.println("Жанр: " + entry.getKey());
            for (MusicTrack track : entry.getValue()) {
                System.out.println(track);
            }
        }
    }
}
