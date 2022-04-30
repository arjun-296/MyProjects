package com.company;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class main_driver
{

    public static void main(String[] args) throws SQLException, playerErrorException
    {


        useroption uo=new useroption();						//global object creation for calling song methods.1

        podcastoptions pdo=new podcastoptions();			//global object creation for calling podcast methods.
        Scanner sc=new Scanner(System.in);


        System.out.println("\t\t\t"+"******************************************************");
        System.out.println("\t\t\t"+"|               Welcome to my JUKEBOX!!!             |");		//application header
        System.out.println("\t\t\t"+"******************************************************");
        System.out.println();

        //TASK-1------------------------------------------------------------------------------------
        String outermenuflag;

        do{
            System.out.println("Enter the choice:");
            System.out.println("*****************");
            System.out.println("1)See all available songs.");
            System.out.println("2)See all available podcasts");
            int entrychoice=sc.nextInt(); 	//taking the user input to enter the switch case


            switch (entrychoice) {
                case 1 -> {
                    uo.printHeader();
                    System.out.println("----------------------------------------------------------------------------------------------------------------");
                    List<song> storesonglist = uo.viewSongList();
                    uo.print(storesonglist);
                    System.out.println();
                    System.out.println();
                    System.out.println("Choose from the dropdown below");
                    System.out.println("******************************");
                    //displaying the menu
                    System.out.println("""
                            1) to view song by artist name
                            2) to view song by genre name
                            3) to view song by album name""");
                    int choicesong = sc.nextInt();
                    switch (choicesong) {
                        case 1 -> {
                            System.out.println("Enter the first letter of the artistname.");
                            sc.nextLine();
                            String artistname = sc.nextLine();
                            List<song> artist = uo.byArtist(storesonglist, artistname);        //displays song by artist name
                            uo.printHeader();
                            System.out.println("--------------------------------------------------------------------------------------------------------------");
                            artist.forEach(song::display);
                        }
                        case 2 -> {
                            System.out.println("Enter the first letter of the genrename");
                            sc.nextLine();
                            String genrename = sc.next();                    //displays song by genre name
                            List<song> genre = uo.byGenre(storesonglist, genrename);
                            uo.printHeader();
                            System.out.println("----------------------------------------------------------------------------------------------------------------");

                            genre.forEach(song::display);
                        }
                        case 3 -> {
                            System.out.println("Enter the first letter of the albumname");
                            sc.nextLine();
                            String albumname = sc.nextLine();                  //displays song by album name
                            List<song> album = uo.byAlbum(storesonglist, albumname);
                            uo.printHeader();
                            System.out.println("----------------------------------------------------------------------------------------------------------------");
                            album.forEach(song::display);
                        }
                        default -> System.out.println("Invalid Selection");
                    }
                }
                //TASK-2-------------------------------------------------------------------------------------
                case 2 -> {
                    List<podcast> podmenu = pdo.podcastList();
                    pdo.podcastMenuHeader();             //printing the podcast menu by default
                    pdo.printPodMenu(podmenu);
                    System.out.println();
                    System.out.println();
                    System.out.println("1)view available podcast details by podcast name");
                    System.out.println("2)view available podcast details by celebrity name");
                    int choicepodcast = sc.nextInt();
                    System.out.println();
                    System.out.println();
                    List<podcast> podetailforsort = pdo.viewPodcastDetailList();    //catches the mixed podcast details present in the database.
                    switch (choicepodcast) {
                        case 1 -> {
                            System.out.println("Enter the starting alphabet of podcastname");
                            sc.nextLine();
                            String podcastname = sc.next();
                            pdo.podcastdetailheader();     //calling the method to sort the user defined podcastand catches it to display it.
                            pdo.printpoddet(pdo.byPodcastname(podetailforsort, podcastname));    //prints the sorted podcast detail list.
                        }
                        case 2 -> {
                            System.out.println("Enter the starting alphabet of celebrity name");
                            sc.nextLine();
                            String celname = sc.next();
                            pdo.podcastdetailheader();
                            pdo.printpoddet(pdo.byCelebrityname(podetailforsort, celname));
                        }
                    }
                }
            }
            System.out.println();
            System.out.println();
            System.out.println("Do you want to continue searching? (y/n)" );	//taking user input to run the loop again.
            outermenuflag=sc.next();
        }while(outermenuflag.equalsIgnoreCase("y"));

        //TASK-3---------------------------------------------------------------------------------------------
        playlist obj=new playlist();
        track t=new track();
        tracklistops tl=new tracklistops(); //objects created to be used in method calling for task3

        String again;

        do {

            System.out.println("Do you want to create your own playlist?  (y/n)");
            String create = sc.next();


            if(create.equalsIgnoreCase("y"))
            {

                System.out.println("Enter the name of the custom playlist to be created.");
                sc.nextLine();
                String newPlayListName=sc.next();
                obj.createPlay(newPlayListName); //creating a new playlist in playlisttable and creating a seperate table of the same name to store the songs and podcasts.

            }

            System.out.println();
            System.out.println("Choose an option to view and add tracks in the new playlist.");
            System.out.println("************************************************************");
            System.out.println("1) View songs and add in playlist.");
            System.out.println("2) View podcasts and add in playlist.");

            int add=sc.nextInt();	//taking input from user to view the songs and podcasts to choose and add in the new playlist.

            switch (add) {
                case 1 -> {
                    List<track> ViewallSongForAddition = tl.getAllTracks(); //calling the method to extract songdetails from DB and storing it in a track-type of Linked list and holding it.
                    t.header();
                    tl.printTracks(ViewallSongForAddition);   //printing the extracted song list for user's choice
                    List<track> flushList = tl.createFlushList();//calling the flushlist method which is an emptylist and is needed as a carrier-list to insert the song in the new playlist.
                    System.out.println();
                    System.out.println("Enter the songID you wish to add in the new playlist");
                    int songAddition = sc.nextInt();
                    List<track> updateDB = tl.addTrackInTracklist(ViewallSongForAddition, flushList, songAddition);
                    System.out.println();
                    obj.showAllPlaylists();//showing all playlists
                    System.out.println();
                    System.out.println("Enter the playlist name in which you want to enter the song");
                    sc.nextLine();
                    String specifyPlaylistName = sc.next();
                    tl.InsertSong(updateDB, specifyPlaylistName); //passing the list with user-selected song to insert the record in the database.
                    System.out.println();
                    System.out.println("Song Added in your playlist");
                }
                case 2 -> {
                    List<track> ViewallpodcastForAddition = tl.getAllPods(); //calling the method to extract podcastdetails from DB and storing it in a track-type of Linked list and holding it.
                    t.header();
                    tl.printTracks(ViewallpodcastForAddition);    //printing the extracted podcastlist for user's choice
                    List<track> flushListPod = tl.createFlushList(); //calling the flushlist method which is an emptylist and is needed as a carrier-list to insert the song in the new playlist.
                    System.out.println();
                    System.out.println("Enter the podcastID you wish to add in the new playlist");
                    int podcastAddition = sc.nextInt();
                    List<track> updatePodDB = tl.addTrackInTracklist(ViewallpodcastForAddition, flushListPod, podcastAddition);
                    System.out.println();
                    obj.showAllPlaylists();        //showing all playlists
                    System.out.println("Enter the playlist name in which you want to enter the podcast");
                    sc.nextLine();
                    String specPlaylistName = sc.next();
                    tl.InsertSong(updatePodDB, specPlaylistName);    //passing the list with user-selected song to insert the record in the database.
                    System.out.println("Podcast Added in your playlist");
                }
            }
            System.out.println();
            System.out.println("Do you want to continue adding? (y/n)" );		//taking user input to run the loop again.
            again=sc.next();


        }while(again.equalsIgnoreCase("y"));

        //TASK-4--------------------------------------------------------------------------------------------

        System.out.println();
        obj.showAllPlaylists();							//showing all playlists
        System.out.println();
        System.out.println("Enter the name of the playlist from which you want to play tracks.");
        sc.nextLine();
        String pn=sc.next();
        List<track>temp2=tl.extractPlaylist(pn);		//extracting updated playlist records to pass the url to the audio input stream(AIS).

        String chooseOther;			//variable for loop management
        String url;					//variable to store the url which is passed further in the AIS.



        System.out.println();
        System.out.println("******************************************************************");
        System.out.println("|       Displaying the songs available in your playlist          |");
        System.out.println("******************************************************************");
        System.out.println();
        t.header();
        tl.printTracks(temp2);	//printing the tracks added in the playlist.

        System.out.println();
        do {

            System.out.println("Enter the track ID to be played");
            int stb=sc.nextInt();
            url=temp2.stream().filter(p->p.getTrackid()==(stb)).toList().get(0).getUrl();	//getting the url of the track by filter method by taking trackID as the input.

            try
            {

                Player audioPlayer =new Player(url);		//passing the URL of the user-selected song into the object of Player class.

                audioPlayer.play();							//calling the play method in the Player class by it's object.

                while (true)
                {
                    System.out.println("1. pause");			// user control menu to control the track behaviour.
                    System.out.println("2. resume");
                    System.out.println("3. restart");
                    System.out.println("4. stop");



                    int ch = sc.nextInt();
                    audioPlayer.userChoice(ch, url);
                    if (ch == 4)
                        break;
                }

//			System.out.println();
//			System.out.println("Do you want to you want to delete any song?");
//			String delchoice=sc.next();
//			if(delchoice.equalsIgnoreCase("y"));
//			{
//				List<track> afterDel=tl.deleteSong(temp2);
//				t.header();
//				System.out.println("==========================");
//				tl.printTracks(afterDel);
//			}

            }

            catch (Exception ex)
            {
                throw new playerErrorException();		//exception throwing if url is not being retrieved after stream().filter() method.


            }

            System.out.println("Choose Another track from the playlist to play? (y/n)");
            chooseOther=sc.next();					//looping to play another song in the same playlist.

        }while(chooseOther.equalsIgnoreCase("y"));

        System.out.println("Thank you for using my Jukebox!!!");
    }





}

