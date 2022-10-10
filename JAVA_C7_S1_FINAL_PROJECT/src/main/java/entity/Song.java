package entity;

import java.sql.Time;

public class Song
{
    private int song_id;
    private String song_name;
    private String genre;
    private Time duration;
    private String album;
    private String artist_name;
    private String Song_url;

    public Song(int song_id, String song_name, String genre, Time duration, String album, String artist_name, String song_url) {
        this.song_id = song_id;
        this.song_name = song_name;
        this.genre = genre;
        this.duration = duration;
        this.album = album;
        this.artist_name = artist_name;
        Song_url = song_url;
    }
    public Song()
    {

    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getSong_url() {
        return Song_url;
    }

    public void setSong_url(String song_url) {
        Song_url = song_url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "song_id=" + song_id +
                ", song_name='" + song_name + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", album='" + album + '\'' +
                ", artist_name='" + artist_name + '\'' +
                '}';
    }
}
