package com.company;

public class track
{

    //attributes of newly created playlist
    private int trackid;
    private String trackname;
    private String trackduration;
    private String tracktype;
    private String url;
    private int pid;

    //empty constructor
    public track()
    {
        super();
    }


    //parametrized constructor
    public track(int trackid, String trackname, String trackduration, String tracktype, String url) {
        super();
        this.trackid = trackid;
        this.trackname = trackname;
        this.trackduration = trackduration;
        this.tracktype = tracktype;
        this.url = url;

    }



    //creating playlist and playlist tables in the database
    public int getTrackid() {
        return trackid;
    }
    public void setTrackid(int trackid) {
        this.trackid = trackid;
    }
    public String getTrackname() {
        return trackname;
    }
    public void setTrackname(String trackname) {
        this.trackname = trackname;
    }
    public String getTrackduration() {
        return trackduration;
    }
    public void setTrackduration(String trackduration) {
        this.trackduration = trackduration;
    }
    public String getTracktype() {
        return tracktype;
    }
    public void setTracktype(String tracktype) {
        this.tracktype = tracktype;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }

    //common printing method for tractype of songlist/podccast list
    void printTest()
    {


        System.out.format("%-20s %-20s %-20s %-20s\n",this.trackid,this.trackname,this.trackduration,this.tracktype);

    }

    //common printing method for tractype of songlist/podcast list
    void header()
    {
        System.out.format("%-20s %-20s %-20s %-20s\n","TrackID","Track Name","Track Duration","Track Type");
        System.out.println("--------------------------------------------------------------------------------");
    }


}
