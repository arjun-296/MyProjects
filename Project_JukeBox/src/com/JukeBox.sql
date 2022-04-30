use mydb
'========================================================================================================'
create table artist(artistID int primary key auto_increment, 
Artistname varchar(20) not null) auto_increment=9002;			-->	'table-1'
'========================================================================================================'
create table song(songid int primary key auto_increment, SongName varchar(20) not null, SongDuration time,
GenreName varchar(20) not null, URL tinytext not null, 
AlbumName varchar(20) , artistID int, 
constraint key_1 foreign key (artistID) 
references artist(artistID))auto_increment=1202;			-->	'table-2'
'========================================================================================================'
create table podcast(podcastID int primary key auto_increment, 
podcast_name varchar(50) not null, numberOfEpisodes int not null) auto_increment=1001;	-->	'table-3'
'========================================================================================================'
create table podcastdetail(id int primary key auto_increment, 
episode_Name varchar(50) not null, Celebrity_Name varchar(20), duration time,
URL tinytext not null,
DateofPublish date not null, podcastID int, 											-->'table -4'
constraint key2 foreign key (podcastID) references podcast(podcastID))auto_increment=2001;
'========================================================================================================'
create table playlist(playlistID int primary key auto_increment, PlaylistName varchar(25))auto_increment=3001; -->'table-5'
'========================================================================================================'
'--------TASK 1 Tables-----------'
select *from artist;
select * from song;
desc artist;
desc song;
'-----------TASK 2 Tables------------'
select *from podcast;
select * from podcastdetail;
desc podcast;
desc podcastdetail;
'----------TASK 3 Tables-------------'
select *from playlist;
//'Further tables will be created at runtime for different playlists.'
desc playlist


---------------------------------------------------------------------------------------------------------------------
"create table customsearch(trackid int primary key auto_increment,
trackname varchar(25) not null, trackDuration time ,URL varchar(50), 
tracktype varchar(25)not null, songid int, podcastID int,
pod_id int, playlistID int,artistID int,  

constraint key_3p foreign key(songid) references song(songid),
constraint key_4p foreign key (pod_id) references podcastdetail(id), 
constraint key_5p foreign key (playlistID) references playlist(playlistID),
constraint key_6p foreign key (podcastID) references podcast(podcastID),
constraint key_7p foreign key (artistID) references artist(artistID))auto_increment=5001;"
 
 drop table customsearch
 
 
 desc artist;
 desc  song;
 
 desc podcast;
 desc podcastdetail;
 
 desc playlist;
 desc customsearch;
 
 select * from artist
 insert into artist (Artistname )values("Arijit Singh"),("Pitbull"),("Zayn malik"),("Honey singh")
 set sql_safe_updates=0

select *from song
insert into song (SongName, SongDuration,GenreName,URL,artistID) values
("Dheere Dheere",'00:03:59',"Bollywood Pop", "erqw//wesd//sd" ,5 )

desc podcast;
desc podcastdetail;
 
insert  into podcast(podacast_name,numberOfEpisodes) values ("MMA hour with ariel helwani",2);


insert into podcastdetail(episode_Name,Celebrity_Name,URL,DateofPublish,podcastID)
values("The ultimate fighter","Masvidal","http//dfg//dgf", '2020-08-21',1001),
("The Style Bender","Israel Adensanya","http//iz/ad", '2020-10-02',1001),
("The Mystique Mac","Connor Mcgregor","http//cm//dgf", '2021-01-02',1001)

insert into podcastdetail(episode_Name,Celebrity_Name,URL,DateofPublish,podcastID)
values("The EAGLE with ariel","Khabib","http//drw//dgf", '2020-06-30',1002),
("The Cowboy with ariel","Donald Cerrone","http//dfd/cvcv", '2021-01-02',1002),
("The Mystique Mac with ariel","Connor Mcgregor","http//lm//dgf", '2021-03-19',1002)

delete from podcastdetail where episode_name like "The Mystique Mac with ariel"

select * from artist;
select * from song;					
use mydb
select * from podcast;
select * from podcastdetail;

select * from playlist;
 //"seperate playlists will be created from the program at runtime"
 
 --------------------------------------inserting dummy values----------------------------------------------
 insert into playlist (PlaylistName) values("PlayList1"),("PlayList2");
 
insert into customsearch(trackname,trackDuration,URL,tracktype,songid,playlistID,Artistid)
 values
 ("bekhayali",'00:03:20',"sads/sadsd//sd","Indian Pop",1,3001,1),
 ("Dheere Dheere",'00:03:59',"erqw//wesd//sd","Bollywood Pop",6,3001,5),
 ("Pillow Talk",'00:04:20',"erqw//qwtytg","Pop",4,3001,4)
 



----'task-1'--------- 
select * from artist;
select * from song;					


create view genre as
select * from song 
where genrename like 'Pop'							// 'creating view on the base of genre'
select * from genre									//'viewing the genre'

create view artist_table as
select songid,songname,songduration,genrename,artistname from song
inner join artist
on artist.artistid=song.artistid					//'creating view on the base of artist name'
select * from artist_table							//'viewing the newly made artist_table'


create view album_table as
select songid,songname,songduration,genrename,artistname,albumname from song
inner join artist
on artist.artistid=song.artistid					
where albumname is not null							//'creating view on the base of album name'
select * from album_table							//'viewing the newly made album_table'

        
------'task-2'--------
select * from podcast;									
select * from podcastdetail;																	

-------'task-3'-------
select * from playlist;
															


---------------------------------"inserting records in artist and song table"------------------------------------
select * from artist;
select * from song;		

insert into artist(artistname) values
("Ritviz"),
("Arijit Singh"),
("Sundihi Chauhan"),
("Shaan"),("Armaan Malik"),
("Ayushman Khurana"),
("Lele Pons"),("Venga Boys"),
("Akshay Verma"),
("Danny Olston"),
("Afrojack"),
("Skrillex"),("Tiesto"),("Illenium")



insert into song (songname,songduration,genrename,URL,albumname,artistid) values
('bollywood edm','00:33:07',"EDM","C:\\Users\\dell\\Desktop\\Resource Folder\\bollywood edm.wav","NA",9012),
("bubble gum","00:02:34","Party","C:\\Users\\dell\\Desktop\\Resource Folder\\bubble gum.wav","NA",9008),
("loud edm","00:16:28","EDM","C:\\Users\\dell\\Desktop\\Resource Folder\\loud edm.wav","NA",9014),
("love is gone","00:03:33","EDM","C:\\Users\\dell\\Desktop\\Resource Folder\\love is gone.wav","NA",9011),
("fitoor","00:04:43","Romance","C:\\Users\\dell\\Desktop\\Resource Folder\\fitoor.wav","NA",9003),
("mirza","00:04:15","Party","C:\\Users\\dell\\Desktop\\Resource Folder\\mirza.wav","NA",9015),
("nashe si chadh gyi","00:03:18","Pop","C:\\Users\\dell\\Desktop\\Resource Folder\\nashe si chah gyi.wav","NA",9003),
("rum whiskey","00:04:05","Party","C:\\Users\\dell\\Desktop\\Resource Folder\\rum whiskey.wav","NA",9010),
("tujhe rab mana","00:04:59","Romance","C:\\Users\\dell\\Desktop\\Resource Folder\\tujhe rab mana.wav","NA",9005),
("pani da rang","00:04:05","Romance","C:\\Users\\dell\\Desktop\\Resource Folder\\paani da rang.wav","NA",9007),
("love you","00:04:05","Party","C:\\Users\\dell\\Desktop\\Resource Folder\\love you.wav","NA",9006),
("chalo chalein","00:03:04","Groove","C:\\Users\\dell\\Desktop\\Resource Folder\\chalo chalein.wav","Liggi",9002),
("ab to aaye ja",'00:05:25',"Pop","C:\\Users\\dell\\Desktop\\Resource Folder\\ab to aaye ja.wav","Liggi",9002),
("thandi hawa","00:03:23","Groove","C:\\Users\\dell\\Desktop\\Resource Folder\\thandi hawa.wav","Liggi",9002),
("we like to party","00:03:44","EDM","C:\\Users\\dell\\Desktop\\Resource Folder\\we like to party.wav","Venga Book",9009),
("we r going to ibiza","00:03:36","Party","C:\\Users\\dell\\Desktop\\Resource Folder\\we r going to ibiza.wav","Venga Book",9009)


select * from podcast;									
select * from podcastdetail;	

use mydb
 insert into podcast(podcast_name, numberofepisodes)values(" Hound of the Baskerville",2),
 ("Adventures of Sherlock holmes",2)
 
 insert into podcastdetail(episode_name,celebrity_name,duration,url,dateofpublish,podcastid)
 values
 ("Murder","Arthur Doyle","00:29:30","C:\\Users\\dell\\Desktop\\Resource Folder\\HOB1.wav",'2020-08-12',1001),
 ("hound","Arthur Doyle","00:24:40","C:\\Users\\dell\\Desktop\\Resource Folder\\HOB2.wav",'2020-09-12',1001),
 ("Trip to London","Sherlock Holmes","00:23:33","C:\\Users\\dell\\Desktop\\Resource Folder\\ASH1.wav",'2018-04-19',1002),
 ("Great Escape ","Sherlock Holmes","00:23:52","C:\\Users\\dell\\Desktop\\Resource Folder\\ASH2.wav",'2018-05-24',1002)






