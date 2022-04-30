package com.company;

public class podcast
{
    //attributes
    private int id;
    private String episodename;
    private String celebrityname;
    private String duration;
    private String url;
    private String dateofpublish;
    private int podcastid;
    private int episodes;
    private String podcastname;

    //getter and setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEpisodename() {
        return episodename;
    }
    public void setEpisodename(String episodename) {
        this.episodename = episodename;
    }
    public String getCelebrityname() {
        return celebrityname;
    }
    public void setCelebrityname(String celebrityname) {
        this.celebrityname = celebrityname;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDateofpublish() {
        return dateofpublish;
    }
    public void setDateofpublish(String dateofpublish) {
        this.dateofpublish = dateofpublish;
    }
    public int getPodcastid() {
        return podcastid;
    }
    public void setPodcastid(int podcastid) {
        this.podcastid = podcastid;
    }
    public int getEpisodes() {
        return episodes;
    }
    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }
    public String getPodcastname() {
        return podcastname;
    }
    public void setPodcastname(String podcastname) {
        this.podcastname = podcastname;
    }

    //Custome parametrized constructor, used to fill the details of podcasttable from DB into a list for display purpose
    public podcast(int podcastid, String podcastname,String celebrityname,int episodes) {

        this.podcastid = podcastid;
        this.episodes = episodes;
        this.podcastname = podcastname;
        this.celebrityname=celebrityname;

    }
    //parametrized constructor
    public podcast(int id, String episodename, String celebrityname, String duration, String url, String dateofpublish,
                   int podcastid, int episodes, String podcastname) {
        super();
        this.id = id;
        this.episodename = episodename;
        this.celebrityname = celebrityname;
        this.duration = duration;
        this.url = url;
        this.dateofpublish = dateofpublish;
        this.podcastid = podcastid;
        this.episodes = episodes;
        this.podcastname = podcastname;
    }
    //empty constructor for object creation
    public podcast() {
        super();
    }
    //for display podcastdetails purpose
    void displaypoddet()
    {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-25s %-25s %-30s %25s %25s %25s\n",this.id,this.episodename,this.podcastname,this.celebrityname,this.duration,this.dateofpublish);

    }
    //to display podcast menu
    void displaypodmenu()
    {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.format("%-15s %-15s \t %-15s %15s\n",this.podcastid,this.podcastname,this.celebrityname,this.episodes);
    }


}