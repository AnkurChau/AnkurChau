package org.example.hellomaven.DAO;

import org.example.hellomaven.Model.*;

import java.util.Collection;
import java.util.List;

public interface DAOInterface {
    List<Playlist> returnPlaylist();
    List<Song> printAllSongs();
    List<Song> printSongsFromArtist(String artist);
    List<Song> printSongsFromAlbum(String album);
    List<Song> printSongsFromGenre(String genre);
    List<Podcast> printAllPodcasts();
    List<Podcast> printPodcastFromName(String name);
    List<Podcast> printPodcastFromMembers(String members);
    int createPlaylist(User username, String playlistName, String description);
    void insertSongIntoPlaylist(int songID,int playlistID);
    void insertPodcastIntoPlaylist(int podcastID, int playlistID);
    List<String> getAddressFromPlaylist(int playlistID);
    List<String> getAddressFromSonglist(int songID);
    Collection<String> getAddressFromPodcastlist(int podcastID);
    void incrementPlaylistSize(int playlistID);

    void addUser(String username);

    List<Playlist> returnPlaylistByUser(String user);

    List<Item> returnItemsInPlaylist(int playlistID);
}
