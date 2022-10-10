package dao;

import connectionApp.ConnectToDatabase;
import entity.PlayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayListDao
{
    public static Connection con;
    public PlayListDao() throws SQLException, ClassNotFoundException {
        con= ConnectToDatabase.establishconnection();
    }
    public List<PlayList> showPlayList() throws SQLException {
        List<PlayList>list=new ArrayList<>();
        try
        {
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from playLists");
            while (resultSet.next())
            {
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                list.add(new PlayList(id,name));
            }

        } catch (SQLException e) {
           e.printStackTrace();
        }

        return list;
    }
}
