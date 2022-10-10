package entity;

public class PlayList
{
    private int playList_id;
    private String playList_Name;
    private int user_id;

    public PlayList(int playList_id, String playList_Name, int user_id) {
        this.playList_id = playList_id;
        this.playList_Name = playList_Name;
        this.user_id = user_id;
    }

    public PlayList(int id, String name) {
    }

    public PlayList() {
      //this()
    }


    public int getPlayList_id() {
        return playList_id;
    }

    public void setPlayList_id(int playList_id) {
        this.playList_id = playList_id;
    }

    public String getPlayList_Name() {
        return playList_Name;
    }

    public void setPlayList_Name(String playList_Name) {
        this.playList_Name = playList_Name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playList_id=" + playList_id +
                ", playList_Name='" + playList_Name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
