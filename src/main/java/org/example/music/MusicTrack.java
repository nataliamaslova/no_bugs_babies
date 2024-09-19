package org.example.music;

import java.util.Objects;

public class MusicTrack {
    private String title;
    private String artist;
    private String genre;

    public MusicTrack(String trackName, String singerName, String genre) {
        this.title = trackName;
        this.artist = singerName;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "MusicTrack{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicTrack that = (MusicTrack) o;
        return Objects.equals(title, that.title) && Objects.equals(artist, that.artist) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, genre);
    }
}
