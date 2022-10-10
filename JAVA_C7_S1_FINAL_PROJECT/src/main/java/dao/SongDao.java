package dao;

import connectionApp.ConnectToDatabase;
import entity.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDao {
    public static Connection con;

    public SongDao() throws SQLException, ClassNotFoundException {
        con = ConnectToDatabase.establishconnection();
    }
    public static List<Song> showSongList() throws SQLException {  //shows all song
        List<Song> list=new ArrayList<>();
        try
        {
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from Songs");
            while(resultSet.next())
            {
                  int song_id=resultSet.getInt(1);
                  String song_name=resultSet.getString(2);
                  String genre=resultSet.getString(3);
                  Time time_duration=resultSet.getTime(4);
                  String album=resultSet.getString(5);
                  String artist_name=resultSet.getString(6);
                  String song_url=resultSet.getString(7);
                  list.add((new Song(song_id,song_name,genre,time_duration,album,artist_name,song_url)));
            }

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return list;
    }
}
