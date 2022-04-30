package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class playlist
{
    //Attributes
    private int playlistid;
    private String playlistname;

    //Getters and Setters
    public int getPlaylistid() {
        return playlistid;
    }
    public void setPlaylistid(int playlistid) {
        this.playlistid = playlistid;
    }
    public String getPlaylistname() {
        return playlistname;
    }
    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }


    //Empty constructor for object creation
    public playlist() {
        super();
    }



    //create new playlist in the database
    void createPlay(String newPlayListName) throws SQLException
    {

        Connection con = songDBConfig.getConnection();
        PreparedStatement pst=con.prepareStatement("insert into playlist (playlistname) values(?)");
        pst.setString(1, newPlayListName);
        pst.execute();



        String query="create table "+newPlayListName+"(trackid int primary key auto_increment, \r\n"
                + "trackname varchar(20) not null, trackduration time , URL tinytext, \r\n"
                + "tracktype varchar(20) not null)";

        PreparedStatement pst2=con.prepareStatement(query);
        pst2.execute();


    }

    //show all playlists present in the database
    void showAllPlaylists() throws SQLException
    {
        Connection con = songDBConfig.getConnection();
        PreparedStatement pst=con.prepareStatement("Select playlistid,playlistname from playlist");
        ResultSet rs=pst.executeQuery();
        System.out.format("%-15s %-15s\n","Playlist ID","PlayList Name");
        while(rs.next())
        {
            System.out.println("=============||==============||");
            System.out.format("%-15s %-15s\n",rs.getInt(1),rs.getString(2));
        }
    }

}