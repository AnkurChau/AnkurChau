create database jukebox;
use jukebox;
create table user
(
userID varchar(20) not null unique primary key
);
drop table user;
create table song
(
songID int auto_increment primary key,
songName varchar(20) not null,
songGenre varchar(20) not null,
songAlbum varchar(20) not null,
songArtist varchar(20) not null,
songDuration time not null,
songLocation varchar(50) not null
);
alter table song modify songName varchar(50) not null;
drop table song;
create table podcast
(
podcastID int auto_increment primary key,
podcastName varchar(20) not null,
podcastEpisode int not null,
podcastMembers varchar(50) not null,
podcastDuration time not null,
podcastLocation varchar(50) not null
);
drop table podcast;
create table playlist
(
playlistID int auto_increment primary key,
playlistName varchar(20) not null,
username varchar(20) not null,
playlistDescription varchar(50) not null,
playlistLength int not null,
dateCreated date not null,
foreign key(username) references user(userID)
);
alter table playlist modify playlistLength int default 0;
drop table playlist;
create table playlistlist
(
recordID int primary key auto_increment,
playlistID int not null,
itemID int not null,
itemType varchar(10) not null,
foreign key(playlistID) references playlist(playlistID)
);
insert into song(songName,SongGenre,SongAlbum,SongArtist,songduration,songlocation) values('Never gonna give you up','Dance','Album1','Rick Astley','3:29','D:/jukeboxdata/song1.wav');
insert into song(songName,SongGenre,SongAlbum,SongArtist,songduration,songlocation) values('House of fun','pop','Album1','Madness','2:46','D:/jukeboxdata/song2.wav');
insert into song(songName,SongGenre,SongAlbum,SongArtist,songduration,songlocation) values('Quiet Life','electro','Album2','Japan','3:24','D:/jukeboxdata/song3.wav');
insert into song(songName,SongGenre,SongAlbum,SongArtist,songduration,songlocation) values('Its My Life','rock','album2','Talk Talk','3:53','D:/jukeboxdata/song4.wav');
