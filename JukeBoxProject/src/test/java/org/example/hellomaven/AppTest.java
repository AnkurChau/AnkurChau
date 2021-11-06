package org.example.hellomaven;



import org.example.hellomaven.DAO.DAOImplementation;

import org.example.hellomaven.Model.Podcast;
import org.example.hellomaven.Model.Song;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    DAOImplementation dao;
    @Before
    public void setUp()
    {
        dao=new DAOImplementation();
    }
    @After
    public void TearDown()
    {
        dao=null;
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void listReturnedWhenGivenGenre()
    {
        List<Song> song=new ArrayList<>();
        song.add(new Song(1,"Never gonna give you up","Dance","Album1","Rick Astley", LocalTime.parse("00:03:29"),"D:/jukeboxdata/song1.wav"));
        List<Song> song1=new ArrayList<>();
        assertEquals(song.size(),dao.printSongsFromGenre("Dance").size());
        assertNotEquals(0,dao.printSongsFromGenre("Dance").size());
        assertEquals(song1.size(),dao.printSongsFromGenre("Heavy metal").size());
    }
     @Test
    public void listReturnedWhenGivenAlbum()
     {
         List<Song> song1=new ArrayList<>();
         song1.add(new Song(1,"Never gonna give you up","Dance","Album1","Rick Astley", LocalTime.parse("00:03:29"),"D:/jukeboxdata/song1.wav"));
         song1.add(new Song(2,"House of fun","pop","Album1","Madness",LocalTime.parse("00:02:46"),"D:/jukeboxdata/song2.wav"));

         assertEquals(song1.size(),dao.printSongsFromAlbum("Album1").size());
     }
     @Test
    public void listReturnedWhenGivenArtist()
     {
         List<Song> song2=new ArrayList<>();
         song2.add(new Song(1,"Never gonna give you up","Dance","Album1","Rick Astley", LocalTime.parse("00:03:29"),"D:/jukeboxdata/song1.wav"));

         assertEquals(song2.size(),dao.printSongsFromArtist("Rick Astley").size());
     }
     @Test
     public void listReturnedWhenGivenPodcastName()
     {
         List<Podcast> podcast=new ArrayList<>();
         podcast.add(new Podcast(1,"Learn English",1,"Luke",LocalTime.parse("00:15:15"),"D:/jukeboxdata/Podcast1.wav"));
         podcast.add(new Podcast(2,"Learn English",2,"Luke",LocalTime.parse("00:15:15"),"D:/jukeboxdata/Podcast1.wav"));
         List<Podcast> podcast1=new ArrayList<>();
         assertEquals(podcast.size(),dao.printPodcastFromName("Learn English").size());
         assertNotEquals(0,dao.printPodcastFromName("Learn English").size());
         assertEquals(podcast1.size(),dao.printPodcastFromName("Learn Hindi").size());
     }
    @Test
    public void listReturnedWhenGivenMemberName()
    {
        List<Podcast> podcast=new ArrayList<>();
        podcast.add(new Podcast(1,"Learn English",1,"Luke",LocalTime.parse("00:15:15"),"D:/jukeboxdata/Podcast1.wav"));
        podcast.add(new Podcast(2,"Learn English",2,"Luke",LocalTime.parse("00:15:15"),"D:/jukeboxdata/Podcast1.wav"));
        List<Podcast> podcast1=new ArrayList<>();
        assertEquals(podcast.size(),dao.printPodcastFromMembers("Luke").size());
        assertNotEquals(0,dao.printPodcastFromMembers("Luke").size());
        assertEquals(podcast1.size(),dao.printPodcastFromMembers("Terry").size());
    }
    @Test
    public void getAddressFromPlaylistID()
    {
        List<String> address=new ArrayList<>();
        address.add(new String("D:/jukeboxdata/song1.wav"));
        address.add(new String("D:/jukeboxdata/song2.wav"));
        address.add(new String("D:/jukeboxdata/song3.wav"));
        address.add(new String("D:/jukeboxdata/podcast1.wav"));
        address.add(new String("D:/jukeboxdata/podcast2.wav"));
        List<String> address1=new ArrayList<>();
        assertEquals(address.size(),dao.getAddressFromPlaylist(9).size());
        assertNotEquals(0,dao.getAddressFromPlaylist(9).size());
        assertEquals(address1.size(),dao.getAddressFromPlaylist(6).size());
    }
    @Test
    public void listReturnedWhenSongIDisProvided()
    {
        List<String> address=new ArrayList<>();
        address.add(new String("D:/jukeboxdata/song1.wav"));
        List<String> address1=new ArrayList<>();

        assertEquals(address.size(),dao.getAddressFromSonglist(6).size());
        assertNotEquals(0,dao.getAddressFromSonglist(6).size());
        assertEquals(address1.size(),dao.getAddressFromSonglist(3).size());
    }
    @Test
    public void listReturnedWhenPodcastIDisProvided()
    {
        List<String> address=new ArrayList<>();
        address.add(new String("D:/jukeboxdata/podcast1.wav"));
        List<String> address1=new ArrayList<>();
        assertEquals(address.size(),dao.getAddressFromPodcastlist(3).size());
        assertNotEquals(0,dao.getAddressFromPodcastlist(3).size());
        assertEquals(address1.size(),dao.getAddressFromPodcastlist(1).size());
    }

}
