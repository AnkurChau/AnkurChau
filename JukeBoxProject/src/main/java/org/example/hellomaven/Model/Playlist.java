package org.example.hellomaven.Model;

import java.sql.Date;

public class Playlist {
    public int playlistID,playlistLength;
    public String playlistName,playlistDescription;
    public User username;
    public Date date;

    public Playlist(int playlistID,String name,String user,String description,int length,Date date)
    {
        username =new User(user);
        this.playlistID=playlistID;
        playlistName=name;
        playlistLength=length;
        playlistDescription=description;
        this.date=date;
    }
    public String toString()
    {
        return String.format("%10d\t%20s\t%15d\t%20s\t%30s\t%10s",playlistID,playlistName,playlistLength,username,playlistDescription,date);
    }

}
