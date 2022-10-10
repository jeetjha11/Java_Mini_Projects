package Operations;

import connectionApp.ConnectToDatabase;

import java.sql.*;

import Exception.CustomException;

public class PlayListOperations {
    public static Connection con;       //creating the connection object

    public PlayListOperations() throws SQLException, ClassNotFoundException      //No parameterized constructor
    {
        con = ConnectToDatabase.establishconnection();
    }

    public void creatingPlaylist(int userId, String playlistName) throws SQLException, CustomException {    //using this method creating the list
        PreparedStatement preparedStatement = con.prepareStatement("insert into playLists(playlistname,userid) values(?,?)");
        preparedStatement.setString(1, playlistName);
        preparedStatement.setInt(2, userId);
        int row = preparedStatement.executeUpdate();
        if (row > 0)
        {
            System.out.println("Playlist Created Successfully :)");
        } else {
            throw new CustomException("No playList Created");
        }
    }

    public void addingSong(int playListId, int songId) throws SQLException, CustomException {      //adding song using this method
        PreparedStatement ps = con.prepareStatement("insert into Audio values(?,?)");
        ps.setInt(1, playListId);
        ps.setInt(2, songId);
        int count = ps.executeUpdate();
        if (count > 0)
            System.out.println("Song added successfully");
        else
            throw new CustomException("No PlayList found");
    }

    public void addingAlbum(int playlistId, String albumName) throws SQLException, CustomException {       //adding  into album
        PreparedStatement ps = con.prepareStatement("select song_id from songs where album=?");     //using PreparedStatement we are performing the task .
        ps.setString(1, albumName);                                                        //we are taking input at the run time using PreparedStatement
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int songId = rs.getInt(1);
            addingSong(playlistId, songId);
        }
    }

    public void deletingPlaylist(int playListId) throws SQLException, CustomException {
        PreparedStatement ps = con.prepareStatement("delete from playlists where playlistId=?");
        ps.setInt(1, playListId);
        ps.executeUpdate();
        int count = ps.executeUpdate();
        if (count > 0)
            System.out.println("playlist deleted successfully :)");

    }

    public void displayPlayLists(int userId) throws Exception {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select playlistId,playlistName from playlists where userid=" + userId);
            System.out.printf("%5s %10s\n", "PlaylistId", "PlaylistName");
            while (rs.next()) {
                System.out.printf("%5s %10s\n", rs.getInt(1), rs.getString(2));

            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void displayPlaylistContent(int playlistId) throws CustomException {
        try {
            System.out.println("Available Songs in the playlist:");
            System.out.printf("%-10s %10s\n", "SongId", "SongName");
            Statement s = con.createStatement();
            Statement s1 = con.createStatement();
            ResultSet rs = s.executeQuery("select song_id from Audio where playlistid=" + playlistId);
            while (rs.next()) {
                ResultSet rs1 = s1.executeQuery("select song_id,song_name from songs where song_id=" + rs.getInt(1));
                while (rs1.next()) {
                    System.out.printf("%-10s %10s\n", rs1.getInt(1), rs1.getString(2));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 //   public void displaySong(List<Song>allsonglist,)
// for checking the code creating main
    //public static void main(String[] args) throws SQLException, ClassNotFoundException, CustomException {
//        Scanner sc=new Scanner(System.in);
         // PlayListOperations p=new PlayListOperations();
//        System.out.println("enter id");
//        int id=sc.nextInt();
//        System.out.println("enter name");
//        String name=sc.next();
//        p.creatingPlaylist(id,name);
//        List<PlayList> l=new ArrayList<>();
      //  p.displayPlaylistContent(2005);
//        p.addingSong(2005,102);
//        p.addingSong(2005,103);
       // p.addingAlbum(2005,"Teri Mitti (Kesari)");
    //}
}
//main inper


