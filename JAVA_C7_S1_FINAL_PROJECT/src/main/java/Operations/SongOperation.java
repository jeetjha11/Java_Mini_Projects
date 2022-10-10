package Operations;

import entity.Song;

import java.util.*;

public class SongOperation
{
    public List<Song> searchByArtistName(List<Song> allSongList,String artist_name)
    {
        List<Song>list=new ArrayList<>();
        for(Song s:allSongList){
            if(s.getArtist_name().equalsIgnoreCase(artist_name)){
                list.add(s);
            }
        }
        System.out.println(list);
        return list;
    }
    public List<Song> searchBySongName(List<Song> songList,String song_name)
    {
        List<Song>list=new ArrayList<>();
        for(Song s:songList){
            if(s.getSong_name().equalsIgnoreCase(song_name)){
                list.add(s);
            }
        }
        System.out.println(list);
        return list;
    }
    public List<Song> searchBySongId(List<Song> songList,int id)
    {
        List<Song>list=new ArrayList<>();
        for(Song s:songList){
            if(s.getSong_id()==(id)){
                list.add(s);
            }
        }
        Collections.sort(list,(a,b)->a.getSong_id()-b.getSong_id());
        System.out.println(list);
        return list;
    }
    public List<Song> searchByGenre(List<Song> songList,String genre)
    {
        List<Song>list=new ArrayList<>();
        for(Song s:songList){
            if(s.getGenre().equalsIgnoreCase(genre)){
                list.add(s);
            }
        }
       System.out.println(list);
        return list;
    }
    public List<Song>searchByAlbum(List<Song>songList,String albumName)
    {
        List<Song>list=new ArrayList<>();
        for(Song s:songList){
            if(s.getAlbum().equalsIgnoreCase(albumName)){
                list.add(s);
            }
        }
        System.out.println(list);
        return list;
    }

    public void display(List<Song>songList)
    {
        Iterator<Song> I=songList.iterator();
       while (I.hasNext())
       {
           Song S=I.next();
           System.out.println("Song Name: "+S.getSong_name()+"        "+"Song id: "+S.getSong_id());
       }
    }
    public void displayOnce(List<Song>songList)
    {
        Iterator<Song> I=songList.iterator();
        while (I.hasNext())
        {
            Song S=I.next();
            System.out.println(S);
        }
    }

}
