package org.example.hellomaven.Model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Podcast{
    public int podcastID,podcastEpisode;
    public String podcastName,podcastMembers,fileLocation;
    public LocalTime duration;
    public Podcast(int podcastID,String name,int episode,String members,LocalTime duration,String location)
    {
        this.podcastID=podcastID;
        podcastName=name;
        podcastEpisode=episode;
        this.duration=duration;
        podcastMembers=members;
        fileLocation=location;
    }
    public String toString()
    {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("HH:mm:ss");
        String podcastDuration=duration.format(formatter);
        return String.format("%10d\t%20s\t%15s\t%20s\t%10s",podcastID,podcastName,podcastEpisode,podcastMembers,podcastDuration);
    }
}
