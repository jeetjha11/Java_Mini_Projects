package App;

import Operations.MusicPlayOperation;
import Operations.PlayListOperations;
import Operations.SongOperation;
import Operations.UserOperations;
import connectionApp.ConnectToDatabase;
import dao.PlayListDao;
import dao.SongDao;
import entity.AudioData;
import entity.PlayList;
import entity.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JukeBoxMainClass
{
    public static  void main(String[] args) throws Exception
    {
        int n=4520;
        Scanner sc=new Scanner(System.in);
        System.out.println("-------------------------You have successfully Installed-----------------------------");
        Connection con= ConnectToDatabase.establishconnection();
        UserOperations uo = new UserOperations();
        int userId = uo.UserValidate();
        loop:while (true)
        {
            System.out.println("Please select the Task number \n1:Search the Songs \n2:Playlist \n3:AudioPlayer\n4.Exit");
            int choice, choice1, choice2, choice3;
            choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                {
                    SongOperation songOperation=new SongOperation();
                    SongDao songDao=new SongDao();
                    List<Song> allSongList=SongDao.showSongList();
                    songOperation.displayOnce(allSongList);
                    do {


                        System.out.print("1.For view all songs\n"+
                                "2.For searching and sorting songs by artist " +
                                "\n3.For searching and sorting songs by album" +
                                " \n4.For searching and sorting songs by genre" +
                                "\n5.For searching and sorting songs by song name"+
                                "\n6.For back menu");
                        choice1=sc.nextInt();
                        switch (choice1)
                        {
                            case 1:
                            {
                                songOperation.display(allSongList);
                                break;
                            }
                            case 2:
                            {
                                sc.nextLine();
                                System.out.println("Please Enter the Artist Name:");
                                String artist_name="";
                                artist_name+=sc.nextLine();
                                List<Song>searchedShortByArtistName=songOperation.searchByArtistName(allSongList,artist_name);
                                songOperation.display(searchedShortByArtistName);
                                break;
                            }
                            case 3:
                            {
                                sc.nextLine();
                                System.out.println("Please Enter the Album Name:");
                                String album_name="";
                                album_name+=sc.nextLine();
                                List<Song>searchShortByAlbumName=songOperation.searchByAlbum(allSongList,album_name);
                                songOperation.display(searchShortByAlbumName);
                                break;
                            }
                            case 4:
                            {
                                sc.nextLine();
                                System.out.println("Please Enter the Genre name of the song:");
                                String genre_name="";
                                genre_name+=sc.nextLine();
                                List<Song>searchShortByGenreName=songOperation.searchByGenre(allSongList,genre_name);
                                songOperation.display(searchShortByGenreName);
                                break;
                            }
                            case 5:
                            {
                                sc.nextLine();
                                System.out.println("Please Enter the Song Name:");
                                String name="";
                                name+=sc.nextLine();
                                List<Song>searchShortBySongName=songOperation.searchBySongName(allSongList,name);
                                songOperation.display(searchShortBySongName);
                                break;
                            }
                            case 6:
                            {
                                break;
                            }
                            default:
                            {
                                System.out.println("Match Not Found-----Please Enter the valid Choice");
                                break;
                            }
                        }
                    }
                    while (choice1!=6);
                    break ;
                }
                case 2:
                {
                    do
                    {
                        System.out.println("1.Create a Playlist\n" +
                                "2.Insert a song into Playlist\n" +
                                "3.Insert an Album into a Playlist\n" +
                                "4.Delete a Playlist\n" +
                                "5.Display my Playlists\n" +
                                "6.Display Playlist Content\n" +
                                "7.Back Menu\n" +
                                "8.Exit the Application\n");
                        PlayListOperations playListOperations=new PlayListOperations();
                        PlayListDao playListDao=new PlayListDao();
                        PlayList playList=new PlayList();
                        SongOperation songOperation=new SongOperation();
                        SongDao songDao=new SongDao();
                        List<Song> allSongList=SongDao.showSongList();
                        choice2=sc.nextInt();
                        switch (choice2)
                        {
                            case 1:
                            {
                                System.out.println("Please Enter the Name of the playlist which you want to create:\n");
                                String name=sc.next();
                                playListOperations.creatingPlaylist(userId,name);
                                break;
                            }
                            case 2:
                            {
                                songOperation.display(allSongList);
                                System.out.println("Please Enter a Valid Playlist Id:");
                                int p_id=sc.nextInt();
                                System.out.println("Please Enter the Song Id");
                                int s_id=sc.nextInt();
                                playListOperations.addingSong(p_id,s_id);
                                break;
                            }
                            case 3:

                            {
                                songOperation.display(allSongList);
                                System.out.println("Please Enter the Valid Playlist Id:");
                                int id=sc.nextInt();
                                System.out.println("Please Enter the Album Name");
                                String album_name=sc.next();
                                playListOperations.addingAlbum(id,album_name);
                                break;
                            }
                            case 4:
                            {
                                playListOperations.displayPlayLists(userId);
                                System.out.println("Please Enter Your Playlist Valid Id:");
                                int id=sc.nextInt();
                                System.out.println("Do you want to delete this "+id+" playlist permanently\n"
                                +"Press 1 for delete\n" + "Press 2 for Cancel:");
                                int localChoice=sc.nextInt();
                                if (localChoice==1)
                                {
                                    playListOperations.deletingPlaylist(id);
                                    System.out.println("Successfully Deleted:::");
                                    break;
                                }
                                else {
                                    System.out.println("Successfully Canceled: Thank-you:)");
                                   break;
                                }
                            }
                            case 5:
                            {
                               playListOperations.displayPlayLists(userId);
                                break;
                            }
                            case 6:
                            {
                                playListOperations.displayPlayLists(userId);
                                System.out.println("Please Enter the Playlist Id");
                                int local_id=sc.nextInt();
                                playListOperations.displayPlaylistContent(local_id);
                                break;
                            }
                            case 7:
                            {
                                break;
                            }
                            case 8:
                            {
                                System.exit(n);
                            }
                            default:
                            {
                                System.out.println("Incorrect Choice -- Please Enter the Valid Option:)");
                                break;
                            }
                        }
                    }
                    while (choice2!=7);
                    break ;
                }
                case 3:
                {
                    System.out.println("Choose an option to Play Music:-\n" +
                            "1.Playlist\n" +
                            "2.Song\n" +
                            "3.Exit\n");
                    PlayListOperations playListOperations=new PlayListOperations();
                    PlayList playList=new PlayList();
                    PlayListDao playListDao=new PlayListDao();
                    SongOperation songOperation=new SongOperation();
                    SongDao songDao=new SongDao();
                    List<Song>allSongList=SongDao.showSongList();
                    MusicPlayOperation musicPlayOperation=new MusicPlayOperation();
                    List<AudioData> audioList = new ArrayList<>();   //to store the audio
                    choice3=sc.nextInt();
                    do
                    {
                        switch (choice3)
                        {
                            //using playlist playing the song
                            case 1:
                            {
                                playListOperations.displayPlayLists(userId);
                                System.out.println("Enter palylist id to Play the Music");
                                int playList_id=sc.nextInt();
                                int song_id;
                                Statement statement=con.createStatement();
                                Statement statement1=con.createStatement();
                                ResultSet resultSet = statement.executeQuery("select song_id from Audio where playlistid="+ playList_id);
                                while (resultSet.next())
                                {
                                    song_id=resultSet.getInt(1);
                                    ResultSet resultSet1=statement1.executeQuery("select song_name,song_url from Songs where song_Id="+song_id);
                                        while (resultSet1.next())
                                        {
                                            audioList.add(new AudioData(resultSet1.getString(1),resultSet1.getString(2)));
                                        }
                                  //  System.out.println("Size: 1 :  " +audioList.size());
                                }
                               musicPlayOperation.musicPlayerOperation(audioList);
                                break;
                            }
                            case 2:
                            {
                                System.out.println("Please Enter the Song");
                                songOperation.display(allSongList);
                                List<AudioData>audioDataList=new ArrayList<>();
                                Statement statement=con.createStatement();
                                ResultSet resultSet=statement.executeQuery("select song_name,song_url from songs");
                                while (resultSet.next())
                                {
                                    audioDataList.add(new AudioData(resultSet.getString(1),resultSet.getString(2)));
                                }
                               // System.out.println("Size: 2 :  " +audioDataList.size());
                                musicPlayOperation.musicPlayerOperation(audioDataList);
                                break;
                            }
                            case 3:
                            {
                                break;
                            }
                            default:
                            {
                                System.out.println("Invalid Choice");
                            }
                        }
                    }
                    while (choice3!=3);
                    break ;
                }
                case 4:
                {
                    break loop;

                }

            }

        }
    }
}
