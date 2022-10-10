package entity;

public class Audio
{
    private int audioid;
    private int song_id;

    private int playlist_id;

    public int getAudioid() {
        return audioid;
    }

    public void setAudioid(int audioid) {
        this.audioid = audioid;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }



    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public Audio(int audioid, int song_id,  int playlist_id) {
        this.audioid = audioid;
        this.song_id = song_id;
        this.playlist_id = playlist_id;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "audioid=" + audioid +
                ", song_id=" + song_id +
                ", playlist_id=" + playlist_id +
                '}';
    }
}
