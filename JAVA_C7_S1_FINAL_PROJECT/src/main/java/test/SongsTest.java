package test;

import Operations.SongOperation;
import dao.SongDao;
import entity.Song;
import org.testng.annotations.Test;


import java.sql.SQLException;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

//import static org.testng.AssertJUnit.assertEquals;

public class SongsTest {
    SongOperation songImpl = new SongOperation();

    public SongsTest() throws SQLException, ClassNotFoundException {
    }
     SongDao songDao=new SongDao();
    List<Song>songList=SongDao.showSongList();
    @Test
    public void givenSongIdGetSongDetails() {
        assertEquals("Believer", songImpl.searchBySongId(songList, 102).get(0).getSong_name());
        assertEquals("Baby", songImpl.searchBySongId(songList, 104).get(0).getSong_name());
        assertEquals("Twist", songImpl.searchBySongId(songList, 107).get(0).getSong_name());
    }
    @Test
    public void givenSongArtistGetSongDetails() {
        assertEquals("Twist", songImpl.searchByArtistName(songList, "Serina").get(0).getSong_name());
        assertEquals("Natu Natu", songImpl.searchByArtistName(songList, "RRR").get(0).getSong_name());

    }




}


