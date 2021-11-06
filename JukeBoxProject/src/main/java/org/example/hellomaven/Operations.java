package org.example.hellomaven;

import org.example.hellomaven.DAO.DAOImplementation;
import org.example.hellomaven.DAO.DAOInterface;
import org.example.hellomaven.Model.*;

import java.util.*;

public class Operations {
    public DAOInterface dao;
    public void viewPlaylist()
    {
        dao=new DAOImplementation();
        Scanner sc=new Scanner(System.in);
        List<Playlist> playlist=new ArrayList<>();
        int loop=0;
        while(loop==0)
        {
            System.out.println("Press 1 to view all playlists, 2 to view user specific playlist");
            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==1)
            {

                playlist.addAll(dao.returnPlaylist());
                loop=1;
            }
            else if(choice==2)
            {
                System.out.println("Enter username");
                String user=sc.nextLine();
                playlist.addAll(dao.returnPlaylistByUser(user));
                loop=1;
            }
            else
            {
                System.out.println("Enter valid input");
            }
        }

        List<Playlist> playlistQueue=new ArrayList<>();

        for(Playlist p:playlist)
        {
            System.out.printf("%10s\t%20s\t%15s\t%20s\t%30s\t%10s\n","PlaylistID","PlaylistName","PlaylistLength","CreatedBy","PlaylistDescription","CreatedOn");
            System.out.println(p);
            System.out.println("Items in playlist");
            List<Item> items=dao.returnItemsInPlaylist(p.playlistID);
            System.out.printf("%10s %10s %20s %20s","itemType","itemID","itemName","itemDuration");
            for(Item i:items)
            {
                System.out.println(i);
            }
            System.out.println();
        }
        int loop1=0;
        while(loop1==0)
        {
            System.out.println("Select \t1 to add playlistID ID you want to queue\t2 to exit");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1)
            {
                System.out.println("Enter Playlist ID");
                int playlistID=sc.nextInt();
                for(Playlist p:playlist)
                {
                    if(p.playlistID==playlistID)
                    {
                        playlistQueue.add(p);
                    }
                }
            }
            else if(choice==2)
            {
                loop1=1;
            }
            else
            {
                System.out.println("Enter valid input");
            }
        }
        if(playlistQueue.size()>0)
        {
            playOptions(playlistQueue);
        }
    }


    public void createPlaylist()
    {
        dao=new DAOImplementation();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username");
        User username=new User(sc.nextLine());
        dao.addUser(username.getUsername());
        int loop1=0;
        while(loop1==0)
        {
            System.out.println("Press \n1 to view songs\n2 to view podcasts\n3 to exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:viewAllSong();break;
                case 2:viewAllPodcast();break;
                case 3: loop1=1;break;
                default:
                    System.out.println("Enter valid input");
            }

        }
        int loop2=0;
        System.out.println("Enter playlist name");
        String playlistName=sc.nextLine();
        System.out.println("Enter playlist description");
        String description=sc.nextLine();
        while(loop2==0)
        {

            System.out.println("Press \n1 to add song\n2 to add podcast\n3 to exit");
            int choice=sc.nextInt();
            sc.nextLine();
            int playlistID=dao.createPlaylist(username,playlistName,description);
            if(playlistID==0)
            {
                System.out.println("failed to load playlist");
                return;
            }
            switch(choice)
            {
                case 1:
                    System.out.println("Enter song ID");
                    int songId=sc.nextInt();
                    dao.insertSongIntoPlaylist(songId,playlistID);
                    dao.incrementPlaylistSize(playlistID);
                    break;
                case 2:
                    System.out.println("Enter podcast ID");
                    int podcastID=sc.nextInt();
                    dao.insertPodcastIntoPlaylist(podcastID,playlistID);
                    dao.incrementPlaylistSize(playlistID);
                    break;
                case 3:
                    System.out.println("Finished adding items, load playlist from main menu");
                    loop2=1;break;
                default:
                    System.out.println("Enter valid input");
            }
        }
    }

    private void viewAllPodcast()
    {
        dao=new DAOImplementation();
        Scanner sc=new Scanner(System.in);
        List<Podcast> podcast;


        while(true)
        {
            System.out.println("press \n1 to view all podcast episodes\n2 to view podcast episodes by name\n3 to view podcast episodes by member\n4 to exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    podcast=dao.printAllPodcasts();
                    showPodcast(podcast);
                    break;
                case 2:
                    System.out.println("Enter name");
                    String name=sc.nextLine();
                    podcast=dao.printPodcastFromName(name);
                    showPodcast(podcast);
                    break;
                case 3:
                    System.out.println("Enter Member name");
                    String member=sc.nextLine();
                    podcast=dao.printPodcastFromMembers(member);
                    showPodcast(podcast);
                    break;
                case 4: return;
                default:
                    System.out.println("Enter valid input");
            }
        }
    }

    private void viewAllSong()
    {
        dao=new DAOImplementation();
        Scanner sc=new Scanner(System.in);
        List<Song> song;


        while(true)
        {
            System.out.println("press \n1 to view all songs\n2 to view songs in genre\n3 to view songs in a album\n4 to view song by a artist\n5 to exit");
            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    song=dao.printAllSongs();
                    showSongs(song);
                    break;
                case 2:
                    System.out.println("Enter genre");
                    String genre=sc.nextLine();
                    song=dao.printSongsFromGenre(genre);
                    showSongs(song);
                    break;
                case 3:
                    System.out.println("Enter album name");
                    String album=sc.nextLine();
                    song=dao.printSongsFromAlbum(album);
                    showSongs(song);
                    break;
                case 4:
                    System.out.println("Enter artist name");
                    String artist=sc.nextLine();
                    song=dao.printSongsFromArtist(artist);
                    showSongs(song);
                    break;
                case 5: return;
                default:
                    System.out.println("Enter valid input");
            }
        }
    }


    public void viewAllSongs()
    {
        dao=new DAOImplementation();
        Scanner sc=new Scanner(System.in);
        List<Song> song;
        List<Song> allSong=dao.printAllSongs();
        List<Song> songQueue=new ArrayList<>();
        int loop=0;
        while(loop==0)
        {
            System.out.println("press \n1 to view all songs\n2 to view songs in genre\n3 to view songs in a album\n4 to view song by a artist\n5 to exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    song=dao.printAllSongs();
                    showSongs(song);
                    break;
                case 2:
                    System.out.println("Enter genre");
                    String genre=sc.nextLine();
                    song=dao.printSongsFromGenre(genre);
                    showSongs(song);
                    break;
                case 3:
                    System.out.println("Enter album name");
                    String album=sc.nextLine();
                    song=dao.printSongsFromAlbum(album);
                    showSongs(song);
                    break;
                case 4:
                    System.out.println("Enter artist name");
                    String artist=sc.nextLine();
                    song=dao.printSongsFromArtist(artist);
                    showSongs(song);
                    break;
                case 5: loop=1;break;
                default:
                    System.out.println("Enter valid input");
            }
        }
        int loop1=0;
        while(loop1==0)
        {
            System.out.println("Select \t1 to add songID ID you want to queue\t2 to exit");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1)
            {
                System.out.println("Enter Song ID");
                int songID=sc.nextInt();
                for(Song s:allSong)
                {
                    if(s.songID==songID)
                    {
                        songQueue.add(s);
                    }
                }
            }
            else if(choice==2)
            {
                loop1=1;
            }
            else
            {
                System.out.println("Enter valid input");
            }
        }
        if(songQueue.size()>0)
        {
            playOptions(songQueue);
        }
    }
    public <T> void printList(List<T> list)
    {
        list.stream().forEach(r-> System.out.println(r));
    }
    public void showSongs(List<Song> songs)
    {
        System.out.printf("%10s\t%20s\t%15s\t%20s\t%20s\t%10s\n","SongID","SongName","SongGenre","SongAlbum","SongArtist","SongDuration");
        printList(songs);
    }

    public void viewAllPodcasts()
    {
        dao=new DAOImplementation();
        Scanner sc=new Scanner(System.in);
        List<Podcast> podcast;
        List<Podcast> allPodcast=dao.printAllPodcasts();
        List<Podcast> podcastQueue=new ArrayList<>();
        int loop=0;
        while(loop==0)
        {
            System.out.println("press \n1 to view all podcast episodes\n2 to view podcast episodes by name\n3 to view podcast episodes by member\n4 to exit");
            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    podcast=dao.printAllPodcasts();
                    showPodcast(podcast);
                    break;
                case 2:
                    System.out.println("Enter name");
                    String name=sc.nextLine();
                    podcast=dao.printPodcastFromName(name);
                    showPodcast(podcast);
                    break;
                case 3:
                    System.out.println("Enter Member name");
                    String member=sc.nextLine();
                    podcast=dao.printPodcastFromMembers(member);
                    showPodcast(podcast);
                    break;
                case 4: loop=1;break;
                default:
                    System.out.println("Enter valid input");
            }
        }
        int loop1=0;
        while(loop1==0)
        {
            System.out.println("Select \t1 to add podcastID ID you want to queue\t2 to exit");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1)
            {
                System.out.println("Enter podcast ID");
                int podcastID=sc.nextInt();
                for(Podcast p:allPodcast)
                {
                    if(p.podcastID==podcastID)
                    {
                        podcastQueue.add(p);
                    }
                }
            }
            else if(choice==2)
            {
                loop1=1;
            }
            else
            {
                System.out.println("Enter valid input");
            }
        }
        if(podcastQueue.size()>0)
        {
            playOptions(podcastQueue);
        }

    }
    public void showPodcast(List<Podcast> podcasts)
    {
        System.out.printf("%10s\t%20s\t%15s\t%20s\t%10s\n","PodcastID","PodcastName","PodcastEpisode","PodcastMember","PodcastDuration");
        printList(podcasts);
    }
    public <T> void playOptions(List<T> list)
    {
        try
        {
            List<String> URLArray=new ArrayList<>();
            if(list.get(0) instanceof Playlist)
            {
                List<Playlist> playlist=(List<Playlist>) list;
                for(Playlist p:playlist)
                {
                    int playlistID=p.playlistID;
                    URLArray.addAll(dao.getAddressFromPlaylist(playlistID));
                }
            }
            else if(list.get(0) instanceof Song)
            {
                List<Song> song=(List<Song>) list;
                for(Song s:song)
                {
                    int songID=s.songID;
                    URLArray.addAll(dao.getAddressFromSonglist(songID));
                }
            }
            else if(list.get(0) instanceof Podcast)
            {
                List<Podcast> podcast=(List<Podcast>) list;
                for(Podcast p:podcast)
                {
                    int podcastID=p.podcastID;
                    URLArray.addAll(dao.getAddressFromPodcastlist(podcastID));
                }
            }
            else if(list.get(0) instanceof String)
            {
                List<String> url=(List<String>) list;
                for(String s:url)
                {
                    URLArray.add(s);
                }
            }
            else
            {
                System.out.println("ERROR");
            }
            playlistOptions(URLArray);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    private void playlistOptions(List<String> urlArray)
    {
        Scanner sc=new Scanner(System.in);
        ListIterator<String> li=urlArray.listIterator();

        while(li.hasNext())
        {
            String URL = li.next();
            int current = urlArray.indexOf(URL);
            Player pl=new Player(URL);
            pl.audioPlayer();

            System.out.println("press 1 to continue to next song, 2 to exit");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1)
            {
                playerUI(pl,urlArray,current,li);
            }
            else if(choice==2)
            {
                return;
            }
            else
            {
                System.out.println("Enter valid choice");
            }


        }
    }

    private void playerUI(Player pl, List<String> urlArray,int current,ListIterator<String> li)
    {
        Scanner sc=new Scanner(System.in);
        int loop=0;
        long currentFrame=0;
        while (loop==0)
        {
            while(!pl.isActive())
            {
                loop=1;
            }
            System.out.println("Enter \n1 to play\n2 to pause\n3 to resume\n4 to goto next track\n5 to goto previous track\n6 to shuffle\n7 to loop\n8 to continue to next song or exit\n");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice)
            {
                case 1:
                    pl.play();
                    break;
                case 2:
                    currentFrame=pl.pause();
                    break;
                case 3:
                    pl.resume(currentFrame);
                    break;
                case 4:
                    pl.stop();

                    if (current <urlArray.size())
                    {
                        String nextURL=li.next();
                        pl=new Player(nextURL);

                        pl.audioPlayer();
                        pl.play();
                        current++;
                    } else
                    {
                        System.out.println("No next song available,exiting");
                        return;
                    }
                    break;
                case 5:
                    pl.stop();

                    if (current == 0) {
                        System.out.println("No previous song available,exiting");
                        return;
                    } else {
                        li.previous();
                        String previousURL=li.previous();
                        pl=new Player(previousURL);

                        pl.audioPlayer();
                        pl.play();
                        current--;
                    }
                    break;
                case 6:
                    pl.stop();
                    Collections.shuffle(urlArray);
                    playlistOptions(urlArray);
                    break;
                case 7:pl.loop();break;
                case 8:
                    //continue to next track
                    pl.stop();
                    return;

                default:
                    System.out.println("Enter valid input");

            }

        }
    }
}
