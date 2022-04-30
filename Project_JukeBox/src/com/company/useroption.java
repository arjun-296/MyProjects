package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class useroption

{
    Connection con;

    song s= new song();

    //Printing main songlist for further filteration
    List<song> viewSongList() throws SQLException
    {
        Connection con= songDBConfig.getConnection();
        PreparedStatement pst=con.prepareStatement("select songid, songname, songduration, genrename, url, albumname, artistname from song inner join artist using (artistid)");
        ResultSet rs=pst.executeQuery();

        List<song> allSongList=new LinkedList<>();


        while(rs.next())
        {
            song push = new song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
            allSongList.add(push);

        }
        return allSongList;

    }

    //print method for displaying all the songs present in my database from where user can sort the songs based on artist, album and genre
    void print(List<song> allSongList)
    {
        allSongList.forEach(song::display);
    }


    //Method to list song by artist
    public List<song> byArtist(List<song>allSongList,String artistname)
    {

        return allSongList.stream().filter(p->p.getArtistname().startsWith(artistname.toUpperCase())).collect(Collectors.toList());

    }

    //Method to list song by genrename
    public List<song> byGenre(List<song> allSongList, String genrename)
    {
        return allSongList.stream().filter(p->p.getGenre().startsWith(genrename.toUpperCase())).collect(Collectors.toList());

    }
    //Method to list song by albumname
    public List<song> byAlbum(List<song> allSongList,String albumname)
    {

        return allSongList.stream().filter(p->p.getAlbumname().startsWith(albumname.toUpperCase())).collect(Collectors.toList());

    }

    //display header
    public void printHeader() {

        System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n","SongID","SongName","SongDuration","Genre Name","Album Name","Artist Name");



    }

}