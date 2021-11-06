package org.example.hellomaven.Model;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Song{
    public int songID;
    public String songName,songGenre,songAlbum,songArtist,fileLocation;
    public LocalTime duration;

    public Song()
    {

    }
    public Song(int songID,String name,String genre,String album,String artist,LocalTime duration,String location)
    {
        this.songID=songID;
        songName=name;
        songGenre=genre;
        songAlbum=album;
        songArtist=artist;
        this.duration=duration;
        fileLocation=location;
    }

    public String toString()
    {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("HH:mm:ss");
        String songDuration=duration.format(formatter);
        return String.format("%10d\t%20s\t%15s\t%20s\t%20s\t%10s",songID,songName,songGenre,songAlbum,songArtist,songDuration);
    }

}
