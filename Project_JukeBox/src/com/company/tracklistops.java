package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;





public class tracklistops
{


    //retrieving the details of the selected playlist.
    public List<track> extractPlaylist(String pn) throws SQLException			//used in task-4
    {
        Connection con= songDBConfig.getConnection();
        PreparedStatement pst=con.prepareStatement("select * from "+pn);

        ResultSet rs=pst.executeQuery();

        List<track> tracklist=new LinkedList<>();


        while(rs.next())
        {
            track pusht = new track(rs.getInt(1),rs.getString(2),rs.getString(3),
                                    rs.getString(5),rs.getString(4));
            tracklist.add(pusht);

        }
        return tracklist;

    }


    //unloading the record from songtable and storing it in tracktype of LinkedList.
    List<track> getAllTracks() throws SQLException
    {
        Connection con= songDBConfig.getConnection();
        PreparedStatement pst=con.prepareStatement("select songid, songname, songduration, genrename, url from song inner join artist using (artistid)");
        ResultSet rs=pst.executeQuery();

        List<track> allTrackDisp=new LinkedList<>();


        while(rs.next())
        {
            track push = new track(rs.getInt(1),rs.getString(2),rs.getString(3),
                                    rs.getString(4),rs.getString(5));
            allTrackDisp.add(push);

        }
        return allTrackDisp;

    }


    //unloading the record from podcastdetail table and storing it in tracktype of LinkedList.
    List<track> getAllPods() throws SQLException
    {
        Connection con= songDBConfig.getConnection();
        PreparedStatement pst=con.prepareStatement("select id, episode_name, duration, celebrity_name, url from podcastdetail");

        ResultSet rs=pst.executeQuery();

        List<track> podTrackDetList=new LinkedList<>();


        while(rs.next())
        {
            track pushTrackPodDet = new track(rs.getInt(1), rs.getString(2),rs.getString(3)
                                                ,"podcast", rs.getString(5));
            podTrackDetList.add(pushTrackPodDet);

        }
        return  podTrackDetList;
    }



    //Common method to print all songs and podcasts.
    void printTracks(List<track> list)
    {
        list.forEach(track::printTest);
    }


    //creating flush List
    List<track> createFlushList()
    {
        return new LinkedList<>();
    }


    //Adding song in new tracklist.
    List<track> addTrackInTracklist(List<track> allTrackDisp, List<track> updatePlaylistDB,int tid)
    {

        updatePlaylistDB.addAll(allTrackDisp.stream().filter(i->i.getTrackid()==(tid)).toList());

        return updatePlaylistDB;

    }


    //updating the newly added songs in the new playlist created

    void InsertSong(List<track>templist,String playlistname) throws SQLException
    {
        Connection con= songDBConfig.getConnection();
        PreparedStatement pst=con.prepareStatement("Insert into "+playlistname+" (trackname,trackduration,tracktype,url) values(?,?,?,?)");

        pst.setString(1, templist.stream().toList().get(0).getTrackname());
        pst.setString(2, templist.stream().toList().get(0).getTrackduration());
        pst.setString(3, templist.stream().toList().get(0).getTracktype());
        pst.setString(4, templist.stream().toList().get(0).getUrl());

        pst.execute();

        pst.close();

    }



//		 List<track> deleteSong(List<track>tracklist)
//			{
//
//				int delindex;
//				Scanner sc=new Scanner(System.in);
//				System.out.println("Enter the song to be deleted");
//				delindex=sc.nextInt();
//
//				if(delindex<tracklist.size())
//				{
//					tracklist.remove(delindex-1);
//				}
//				else
//				{
//					System.out.println("INVALID SONGNUMBER ENTERED!!!");
//					//delete(listofmusic);
//				}
//
//				return tracklist;
//
//			}

}
