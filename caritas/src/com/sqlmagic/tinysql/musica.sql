create table artista ( id_artista int, id_compania int, nombre_artista char(50) );
create table compania ( id_compania int, nombre_compania char(30) );
create table disco ( id_disco int, nombre_disco char(60), anio int );
create table artista_disco ( id_artista int, id_disco int );
create table cancion ( id_cancion int, id_genero int, nombre_cancion char(50), duracion char(12), popularidad int, no_track int );
create table disco_cancion ( id_disco int, id_cancion int );
create table genero ( id_genero int, nombre_genero char(40) );


insert into compania ( id_compania, nombre_compania ) values (  1, "Sony Music" );
insert into compania ( id_compania, nombre_compania ) values (  2, "Epic Music" );
insert into compania ( id_compania, nombre_compania ) values (  3, "Universal Music" );
insert into compania ( id_compania, nombre_compania ) values (  4, "Open Record" );
insert into compania ( id_compania, nombre_compania ) values (  5, "Wagram Music" );
insert into compania ( id_compania, nombre_compania ) values (  6, "Emi Records" );
insert into compania ( id_compania, nombre_compania ) values (  7, "Warner Bros. Records" );
insert into compania ( id_compania, nombre_compania ) values (  8, "Polygram / Polydor" );
insert into compania ( id_compania, nombre_compania ) values (  9, "Bmg Music" );
insert into compania ( id_compania, nombre_compania ) values ( 10, "Warner Music Group" );
insert into compania ( id_compania, nombre_compania ) values ( 11, "Sony Music Group" );
insert into compania ( id_compania, nombre_compania ) values ( 12, "Universal Music Group" );
insert into compania ( id_compania, nombre_compania ) values ( 13, "Sony Music Entertaiment" );


insert into genero ( id_genero, nombre_genero ) values (  1, "Rock" );
insert into genero ( id_genero, nombre_genero ) values (  2, "Jazz" );
insert into genero ( id_genero, nombre_genero ) values (  3, "Pop" );
insert into genero ( id_genero, nombre_genero ) values (  4, "Salsa" );
insert into genero ( id_genero, nombre_genero ) values (  5, "Cumbia" );
insert into genero ( id_genero, nombre_genero ) values (  6, "Clasica" );
insert into genero ( id_genero, nombre_genero ) values (  7, "Metalica" );
insert into genero ( id_genero, nombre_genero ) values (  8, "Balada" );
insert into genero ( id_genero, nombre_genero ) values (  9, "Bachata" );
insert into genero ( id_genero, nombre_genero ) values ( 10, "Dance" );
insert into genero ( id_genero, nombre_genero ) values ( 11, "Disco" );
insert into genero ( id_genero, nombre_genero ) values ( 12, "Funk" );
insert into genero ( id_genero, nombre_genero ) values ( 13, "New age" );
insert into genero ( id_genero, nombre_genero ) values ( 14, "Punk" );
insert into genero ( id_genero, nombre_genero ) values ( 15, "Reggae" );
insert into genero ( id_genero, nombre_genero ) values ( 16, "Rhythm and blues" );
insert into genero ( id_genero, nombre_genero ) values ( 17, "Rumba" );
insert into genero ( id_genero, nombre_genero ) values ( 18, "Soul" );
insert into genero ( id_genero, nombre_genero ) values ( 19, "Urban" );
insert into genero ( id_genero, nombre_genero ) values ( 20, "Hip Hop" );
insert into genero ( id_genero, nombre_genero ) values ( 21, "Folklorica" );
insert into genero ( id_genero, nombre_genero ) values ( 22, "Banda" );
insert into genero ( id_genero, nombre_genero ) values ( 23, "Duranguense" );
insert into genero ( id_genero, nombre_genero ) values ( 24, "Reggaethon" );
insert into genero ( id_genero, nombre_genero ) values ( 25, "Nortena" );
insert into genero ( id_genero, nombre_genero ) values ( 26, "Barroca" );
insert into genero ( id_genero, nombre_genero ) values ( 27, "Gotica" );
insert into genero ( id_genero, nombre_genero ) values ( 28, "Huaracha" );
insert into genero ( id_genero, nombre_genero ) values ( 29, "Tango" );
insert into genero ( id_genero, nombre_genero ) values ( 30, "Samba" );


insert into artista ( id_artista, id_compania, nombre_artista ) values ( 1, 2, "Niche" );
insert into artista ( id_artista, id_compania, nombre_artista ) values ( 2, 4, "Metallica" );
insert into artista ( id_artista, id_compania, nombre_artista ) values ( 3, 2, "Emmanuel" );
insert into artista ( id_artista, id_compania, nombre_artista ) values ( 4, 3, "Epica" );
insert into artista ( id_artista, id_compania, nombre_artista ) values ( 5, 1, "Wolgang Amadeus Mozart" );

insert into disco ( id_disco, nombre_disco, anio ) values (  1, "The best", 1990 );
insert into disco ( id_disco, nombre_disco, anio ) values (  2, "Intimamente", 1980 );
insert into disco ( id_disco, nombre_disco, anio ) values (  3, "Master puppeds", 1986 );
insert into disco ( id_disco, nombre_disco, anio ) values (  4, "The Phantom Agony", 2003 );
insert into disco ( id_disco, nombre_disco, anio ) values (  5, "La sinfonia 1 en mi bemol mayor", 1765 );

insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values (  1, 8, "Con olor a hierba", "3:58", 8, 7 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values (  2, 8, "Quiero dormir cansado", "3:25", 8, 4 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values (  3, 7, "Master of puppets", "8:38", 10, 2 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values (  4, 4, "Cali pachanguero", "4:10", 9, 3 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values (  5, 4, "Gotas de lluvia", "4.25", 8, 7 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values (  6, 7, "The phantom agony", "9:01", 8, 9 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values (  7, 6, "Molto allegro", "22:12", 8, 1 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values (  8, 4, "Duele mas", "5:38", 8, 1 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values (  9, 4, "Una aventura", "5:02", 7, 3 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values ( 10, 8, "Insoportablemente bella", "4:07", 9, 1 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values ( 11, 8, "El dia que puedas", "3:48", 10, 2 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values ( 12, 8, "Battery", "5:10", 7, 1 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values ( 13, 8, "Damage inc", "5:08", 7, 8 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values ( 14, 8, "Welcome home", "6:28", 7, 4 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values ( 15, 8, "Illusive consensus", "4:59", 6, 5 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values ( 16, 8, "Run for fall", "6:31", 8, 7 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values ( 17, 6, "Andante", "18:12", 8, 2 );
insert into cancion ( id_cancion, id_genero, nombre_cancion, duracion, popularidad, no_track ) values ( 18, 6, "Presto", "12:12", 8, 3 );

insert into disco_cancion ( id_disco, id_cancion ) values (  1,  4 );
insert into disco_cancion ( id_disco, id_cancion ) values (  1,  5 );
insert into disco_cancion ( id_disco, id_cancion ) values (  2,  1 );
insert into disco_cancion ( id_disco, id_cancion ) values (  2,  2 );
insert into disco_cancion ( id_disco, id_cancion ) values (  3,  3 );
insert into disco_cancion ( id_disco, id_cancion ) values (  4,  6 );
insert into disco_cancion ( id_disco, id_cancion ) values (  5,  7 );
insert into disco_cancion ( id_disco, id_cancion ) values (  1,  8 );
insert into disco_cancion ( id_disco, id_cancion ) values (  1,  9 );
insert into disco_cancion ( id_disco, id_cancion ) values (  2, 10 );
insert into disco_cancion ( id_disco, id_cancion ) values (  3, 11 );
insert into disco_cancion ( id_disco, id_cancion ) values (  3, 12 );
insert into disco_cancion ( id_disco, id_cancion ) values (  3, 14 );
insert into disco_cancion ( id_disco, id_cancion ) values (  4, 15 );
insert into disco_cancion ( id_disco, id_cancion ) values (  4, 16 );
insert into disco_cancion ( id_disco, id_cancion ) values (  5, 17 );
insert into disco_cancion ( id_disco, id_cancion ) values (  5, 18 );


insert into artista_disco ( id_artista, id_disco ) values ( 1, 1 );
insert into artista_disco ( id_artista, id_disco ) values ( 2, 3 );
insert into artista_disco ( id_artista, id_disco ) values ( 3, 2 );
insert into artista_disco ( id_artista, id_disco ) values ( 4, 4 );
insert into artista_disco ( id_artista, id_disco ) values ( 5, 5 );