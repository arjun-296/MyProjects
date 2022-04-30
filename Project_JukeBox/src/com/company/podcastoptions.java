package com.company;


//necessary imports for this class
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class podcastoptions
{

    podcast pd=new podcast();				//object creation for podcast class using empty constructor

//--------------------------------------------podcast list (DBMS Podcast Table-1) code-------------------------------------

    //method to unload the podcast to a list
    List<podcast> podcastList() throws SQLException
    {

        Connection con=songDBConfig.getConnection();
        PreparedStatement pst= con.prepareStatement("Select podcastid, podcast_name, numberofepisodes, celebrity_name from podcast "
                + "inner join podcastdetail using (podcastid) group by celebrity_name");
        ResultSet rs=pst.executeQuery();
        List<podcast>pod=new LinkedList<>();
        while(rs.next())
        {

            podcast pushpod= new podcast(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getInt(3));
            pod.add(pushpod);

        }
        return pod;


    }


    //method to print the podcastmenu, also refers to the fields specified in the podcast POJO class
    void printPodMenu(List<podcast> podmenulist)
    {
        podmenulist.forEach(podcast::displaypodmenu);
    }

    //method for printing the header of the podcastmenu table
    void podcastMenuHeader()
    {
        System.out.format("%-20s %-20s %-20s %20s\n","Podcast ID","Podcast Name","   Celebrity Name","Number of Epsiodes");
    }

    //-----------------------------------------------------podcast detail list(DBMS Podcast table-2) code for searching on userinput-------------------


    //method to unload the podcastdetail from DB to list
    List<podcast> viewPodcastDetailList() throws SQLException
    {
        Connection con= songDBConfig.getConnection();
        PreparedStatement pst=con.prepareStatement("select id,episode_name,celebrity_name,duration,url,dateofpublish,podcastid,numberofepisodes,podcast_name"
                + " from podcastdetail inner join podcast using (podcastid)");
        ResultSet rs=pst.executeQuery();

        List<podcast> podDetList=new LinkedList<>();


        while(rs.next())
        {
            podcast pushPodDet = new podcast(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getInt(7), rs.getInt(8), rs.getString(9));
            podDetList.add(pushPodDet);

        }
        return  podDetList;

    }



    //-----------------------------------------------------sorted podcast detail list code (on the basis of podcast name)-------------------

    //method to sort the podcast by podcastname
    List<podcast> byPodcastname(List<podcast> podDetList,String podcastname)
    {
        return  podDetList.stream().filter(s->s.getPodcastname().startsWith(podcastname.toUpperCase())).collect(Collectors.toList());

    }




    //-----------------------------------------------------sorted podcast detail list code (on the basis of celebrity name)------------------

    //method to sort the podcast by podcastname
    List<podcast> byCelebrityname(List<podcast> podDetList,String celebrityname)
    {
        return  podDetList.stream().filter(s->s.getCelebrityname().startsWith(celebrityname.toUpperCase())).collect(Collectors.toList());

    }



    //common method to print the podcast details, also refers to the fields specified in the podcast POJO class
    void printpoddet(List<podcast> list)
    {
        list.forEach(podcast::displaypoddet);
    }

    //common method for printing the header of the table
    void podcastdetailheader()
    {
        System.out.format("%-25s %-25s %-30s %25s %25s %25s\n","ID","Epidsode name","Podcast Name","Celebrity Name","Epsiode Duration","Date of Publish");
    }

}
