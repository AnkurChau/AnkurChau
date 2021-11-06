package org.example.hellomaven.DAO;

import org.example.hellomaven.DatabaseSetup;
import org.example.hellomaven.Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class DAOImplementation implements DAOInterface
{
    DatabaseSetup dbs;
    @Override
    public List<Playlist> returnPlaylist() {
        List<Playlist> p=new ArrayList<>();
        dbs=new DatabaseSetup();
        try(Connection con=dbs.createConnection())
        {
            String query="Select * from playlist";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                Playlist newObj= new Playlist(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6));
                p.add(newObj);
                while(rs.next())
                {
                    newObj= new Playlist(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6));
                    p.add(newObj);
                }
            }
            else
            {
                System.out.println("No playlist available");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Playlist> returnPlaylistByUser(String user)
    {
        List<Playlist> p=new ArrayList<>();
        dbs=new DatabaseSetup();
        try(Connection con=dbs.createConnection())
        {
            String query="Select * from playlist where username=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,user);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                Playlist newObj= new Playlist(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6));
                p.add(newObj);
                while(rs.next())
                {
                    newObj= new Playlist(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6));
                    p.add(newObj);
                }
            }
            else
            {
                System.out.println("No playlist available");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Song> printAllSongs()
    {
        dbs=new DatabaseSetup();
        List<Song> s=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {
            String query="Select * from song";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                Song newObj= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6).toLocalTime(),rs.getString(7));
                s.add(newObj);
                while(rs.next())
                {
                    newObj= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6).toLocalTime(),rs.getString(7));
                    s.add(newObj);
                }
            }
            else
            {
                System.out.println("No songs available");
            }
            return s;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Song> printSongsFromAlbum(String album)
    {
        dbs=new DatabaseSetup();
        List<Song> s=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {
            String query="Select * from song where songalbum=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,album);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                Song newObj= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6).toLocalTime(),rs.getString(7));
                s.add(newObj);
                while(rs.next())
                {
                    newObj= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6).toLocalTime(),rs.getString(7));
                    s.add(newObj);
                }
            }
            else
            {
                System.out.println("No songs available");
            }
            return s;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Song> printSongsFromArtist(String artist)
    {
        dbs=new DatabaseSetup();
        List<Song> s=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {
            String input="%"+artist+"%";
            String query="Select * from song where songartist like ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,input);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                Song newObj= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6).toLocalTime(),rs.getString(7));
                s.add(newObj);
                while(rs.next())
                {
                    newObj= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6).toLocalTime(),rs.getString(7));
                    s.add(newObj);
                }
            }
            else
            {
                System.out.println("No songs available");
            }
            return s;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Song> printSongsFromGenre(String genre)
    {
        dbs=new DatabaseSetup();
        List<Song> s=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {
            String query="Select * from song where songgenre=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,genre);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                Song newObj= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6).toLocalTime(),rs.getString(7));
                s.add(newObj);
                while(rs.next())
                {
                    newObj= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6).toLocalTime(),rs.getString(7));
                    s.add(newObj);
                }
            }
            else
            {
                System.out.println("No songs available");
            }
            return s;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Podcast> printAllPodcasts()
    {
        dbs=new DatabaseSetup();
        List<Podcast> p=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {
            String query="Select * from podcast";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                Podcast newObj= new Podcast(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getTime(5).toLocalTime(),rs.getString(6));
                p.add(newObj);
                while(rs.next())
                {
                    newObj= new Podcast(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getTime(5).toLocalTime(),rs.getString(6));
                    p.add(newObj);
                }
            }
            else
            {
                System.out.println("No songs available");
            }
            return p;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Podcast> printPodcastFromMembers(String members)
    {
        dbs=new DatabaseSetup();
        List<Podcast> p=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {
            String input="%"+members+"%";
            String query="Select * from podcast where podcastMembers like ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,input);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                Podcast newObj= new Podcast(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getTime(5).toLocalTime(),rs.getString(6));
                p.add(newObj);
                while(rs.next())
                {
                    newObj= new Podcast(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getTime(5).toLocalTime(),rs.getString(6));
                    p.add(newObj);
                }
            }
            else
            {
                System.out.println("No songs available");
            }
            return p;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Podcast> printPodcastFromName(String name)
    {
        dbs=new DatabaseSetup();
        List<Podcast> p=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {
            String query="Select * from podcast where podcastName=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                Podcast newObj= new Podcast(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getTime(5).toLocalTime(),rs.getString(6));
                p.add(newObj);
                while(rs.next())
                {
                    newObj= new Podcast(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getTime(5).toLocalTime(),rs.getString(6));
                    p.add(newObj);
                }
            }
            else
            {
                System.out.println("No songs available");
            }
            return p;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(String username)
    {
        dbs=new DatabaseSetup();

        try(Connection con=dbs.createConnection()) {
            String query = "insert into user(userID) select * from(select ? as userID)as temp where not exists(select * from user where userID=?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, username);
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("User created");
            } else {
                System.out.println("User already exists");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public int createPlaylist(User username, String playlistName, String description)
    {
        dbs=new DatabaseSetup();
        long millis=System.currentTimeMillis();
        Date currentDate= new Date(millis);
        try(Connection con=dbs.createConnection())
        {
            String query="insert into playlist(playlistname,username,playlistDescription,datecreated) select * from(select ? as playlistname, ? as username,? as playlistDescription,? as datecreated)as temp where not exists(select * from playlist where playlistname=? and username=?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,playlistName);
            ps.setString(2,username.getUsername());
            ps.setString(3,description);
            ps.setDate(4,new java.sql.Date(currentDate.getTime()));
            ps.setString(5,playlistName);
            ps.setString(6,username.getUsername());
            int row=ps.executeUpdate();
            if(row>0)
            {
                System.out.println("Playlist created");
            }
            else
            {
                System.out.println("Playlist already exists, adding to existing playlist");
            }

            String query1="Select playlistID from playlist where playlistname=? and username=?";
            PreparedStatement ps1= con.prepareStatement(query1);
            ps1.setString(1,playlistName);
            ps1.setString(2, username.getUsername());
            ResultSet rs=ps1.executeQuery();
            rs.next();
            int playlistID=rs.getInt(1);
            return playlistID;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void insertSongIntoPlaylist(int songID,int playlistID)
    {
        dbs=new DatabaseSetup();
        try(Connection con=dbs.createConnection())
        {
            String query="insert into playlistlist(playlistID,itemID,itemType) values (?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,playlistID);
            ps.setInt(2,songID);
            ps.setString(3,"song");
            int row=ps.executeUpdate();
            if(row>0)
            {
                System.out.println("Song added to playlist");
            }
            else
            {
                System.out.println("failed");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void insertPodcastIntoPlaylist(int podcastID, int playlistID)
    {
        dbs=new DatabaseSetup();
        try(Connection con=dbs.createConnection())
        {
            String query="insert into playlistlist(playlistID,itemID,itemType) values (?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,playlistID);
            ps.setInt(2,podcastID);
            ps.setString(3,"podcast");
            int row=ps.executeUpdate();
            if(row>0)
            {
                System.out.println("Song added to playlist");
            }
            else
            {
                System.out.println("failed");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAddressFromPlaylist(int playlistID)
    {
        dbs=new DatabaseSetup();
        List<String> URL=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {
            String query="select itemID,itemType from playlistlist where playlistID=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,playlistID);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                int itemID=rs.getInt(1);
                String type=rs.getString(2);

                if(type.equalsIgnoreCase("song"))
                {
                    String query1="select songLocation from song where songID=?";
                    PreparedStatement ps1=con.prepareStatement(query1);
                    ps1.setInt(1,itemID);
                    ResultSet rs1=ps1.executeQuery();
                    if(rs1.next())
                    {
                        String fileURL=rs1.getString(1);
                        URL.add(fileURL);
                    }
                    else
                    {
                        System.out.println("song does not exit");
                        return null;
                    }

                }
                else if(type.equalsIgnoreCase("podcast"))
                {
                    String query1="select podcastLocation from podcast where podcastID=?";
                    PreparedStatement ps1=con.prepareStatement(query1);
                    ps1.setInt(1,itemID);
                    ResultSet rs1=ps1.executeQuery();
                    if(rs1.next())
                    {
                        String fileURL=rs1.getString(1);
                        URL.add(fileURL);
                    }
                    else
                    {
                        System.out.println("song does not exit");
                        return null;
                    }
                }
                else
                {
                    System.out.println("Error in getAddressFromPlaylist item type");
                }
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return URL;
    }

    @Override
    public List<String> getAddressFromSonglist(int songID)
    {
        dbs=new DatabaseSetup();
        List<String> URL=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {

            String query1="select songLocation from song where songID=?";
            PreparedStatement ps1=con.prepareStatement(query1);
            ps1.setInt(1,songID);
            ResultSet rs1=ps1.executeQuery();
            if(rs1.next())
            {
                String fileURL=rs1.getString(1);
                URL.add(fileURL);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return URL;
    }

    @Override
    public Collection<String> getAddressFromPodcastlist(int podcastID)
    {
        dbs=new DatabaseSetup();
        List<String> URL=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {

            String query1="select podcastLocation from podcast where podcastID=?";
            PreparedStatement ps1=con.prepareStatement(query1);
            ps1.setInt(1,podcastID);
            ResultSet rs1=ps1.executeQuery();
            if(rs1.next())
            {
                String fileURL=rs1.getString(1);
                URL.add(fileURL);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return URL;
    }

    @Override
    public void incrementPlaylistSize(int playlistID)
    {
        dbs=new DatabaseSetup();

        try(Connection con=dbs.createConnection())
        {

            String query1="select playlistlength from playlist where playlistID=?";
            PreparedStatement ps1=con.prepareStatement(query1);
            ps1.setInt(1,playlistID);
            ResultSet rs1=ps1.executeQuery();
            rs1.next();
            int count=rs1.getInt(1);

            count++;

            String query2="update playlist set playlistLength=? where playlistID=?";
            PreparedStatement ps2=con.prepareStatement(query2);
            ps2.setInt(1,count);
            ps2.setInt(2,playlistID);
            int row=ps2.executeUpdate();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> returnItemsInPlaylist(int playlistID)
    {
        dbs=new DatabaseSetup();
        List<Item> items=new ArrayList<>();
        try(Connection con=dbs.createConnection())
        {
            String query="select itemID,itemType from playlistlist where playlistID=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,playlistID);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                int itemID=rs.getInt(1);
                String type=rs.getString(2);

                if(type.equalsIgnoreCase("song"))
                {
                    String query1="select songID,songName,songDuration from song where songID=?";
                    PreparedStatement ps1=con.prepareStatement(query1);
                    ps1.setInt(1,itemID);
                    ResultSet rs1=ps1.executeQuery();
                    if(rs1.next())
                    {
                        Item itemObj=new Item("Song",rs1.getInt(1),rs1.getString(2),rs1.getTime(3).toLocalTime());
                        items.add(itemObj);
                    }
                    else
                    {
                        System.out.println("song does not exit");
                        return null;
                    }

                }
                else if(type.equalsIgnoreCase("podcast"))
                {
                    String query1="select podcastID,podcastName,podcastDuration from podcast where podcastID=?";
                    PreparedStatement ps1=con.prepareStatement(query1);
                    ps1.setInt(1,itemID);
                    ResultSet rs1=ps1.executeQuery();
                    if(rs1.next())
                    {
                        Item itemObj=new Item("Podcast",rs1.getInt(1),rs1.getString(2),rs1.getTime(3).toLocalTime());
                        items.add(itemObj);
                    }
                    else
                    {
                        System.out.println("song does not exit");
                        return items;
                    }
                }
                else
                {
                    System.out.println("Error in getAddressFromPlaylist item type");
                }
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return items;

    }
}
