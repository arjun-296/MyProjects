package com.company;

public class song
{
    //attributes
    private int songid;
    private String songname;
    private String songduration;
    private String genre;
    private String url;
    private String albumname;
    private String artistname;

    //Getter and Setters
    public String getArtistname() {
        return artistname;
    }
    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }
    public int getSongid() {
        return songid;
    }
    public void setSongid(int songid) {
        this.songid = songid;
    }
    public String getSongname() {
        return songname;
    }
    public void setSongname(String songname) {
        this.songname = songname;
    }
    public String getSongduration() {
        return songduration;
    }
    public void setSongduration(String songduration) {
        this.songduration = songduration;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getAlbumname() {
        return albumname;
    }
    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    //Parametrized Constructor
    public song(int songid, String songname, String songduration, String genre, String url, String albumname,
                String artistname) {
        super();
        this.songid = songid;
        this.songname = songname;
        this.songduration = songduration;
        this.genre = genre;
        this.url = url;
        this.albumname = albumname;
        this.artistname = artistname;
    }

    //Empty Constructor
    public song() {

    }

    //Display method for displaying main songlist
    void display()
    {

        System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n",this.songid,this.songname,this.songduration,this.genre,this.albumname,this.artistname);
    }





}