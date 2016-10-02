package playlist_editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static BufferedReader B = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        ArrayList<Song> playlist = new ArrayList<Song>();
        Iterator<Song> playlistIterator = playlist.iterator();
        ArrayList<Song> templist = new ArrayList<Song>();
        Iterator<Song> templistIterator = templist.iterator();
        Song songtemp = new Song();
        int input=-1, input2=-1, release_year, found;
        String artist, title, album;
        do
        {
            System.out.println("PLAYLIST EDITOR");
            System.out.println("");
            System.out.println("[1] Insert song");
            System.out.println("[2] Show all songs");
            System.out.println("[3] Find songs");
            System.out.println("[4] Modify song info");
            System.out.println("[5] Delete song");
            System.out.println("[6] Load preset playlist");
            System.out.println("[0] Exit");
            System.out.println("Choice: ");input = Integer.parseInt(B.readLine());
            System.out.println("");
            switch(input)
            {
                case 1: songtemp = songtemp.inputSong();
                        playlist.add(songtemp);
                        System.out.println("Song insertion successful!");
                        System.out.println("");
                        break;
                case 2: if(playlist.isEmpty())
                        {
                            System.out.println("You don't have anything in the playlist!");
                            System.out.println("");
                        }
                        else
                        {
                            playlistIterator = playlist.iterator();
                            while(playlistIterator.hasNext())
                            {
                                playlistIterator.next().printSong();
                            }
                            System.out.println(playlist.size()+" song(s) found!");
                            System.out.println("");
                        }
                        break;
                case 3: if(playlist.isEmpty())
                        {
                            System.out.println("You don't have anything in the playlist!");
                            System.out.println("");
                        }
                        else
                        {
                            playlistIterator = playlist.iterator();
                            do
                            {
                                found = 0;
                                songtemp.selectType();
                                System.out.println("Choice: ");input2 = Integer.parseInt(B.readLine());
                                System.out.println("");
                                switch(input2)
                                {
                                    case 1: System.out.println("Insert artist: ");artist = B.readLine();
                                            System.out.println("");
                                            while(playlistIterator.hasNext())
                                            {
                                                Song song = playlistIterator.next();
                                                if(song.getArtist().equalsIgnoreCase(artist))
                                                {
                                                    song.printSong();
                                                    found++;
                                                }
                                            }
                                            if(found > 0)
                                            {
                                                System.out.println(found+" song(s) found!");
                                                System.out.println("");
                                            }
                                            else
                                            {
                                                System.out.println("There are no songs of this artist!");
                                                System.out.println("");
                                            }
                                            playlistIterator = playlist.iterator();
                                            break;
                                    case 2: System.out.println("Insert title: ");title = B.readLine();
                                            System.out.println("");
                                            while(playlistIterator.hasNext())
                                            {
                                                Song song = playlistIterator.next();
                                                if(song.getTitle().equalsIgnoreCase(title))
                                                {
                                                    song.printSong();
                                                    found++;
                                                }
                                            }
                                            if(found > 0)
                                            {
                                                System.out.println(found+" song(s) found!");
                                                System.out.println("");
                                            }
                                            else
                                            {
                                                System.out.println("There are no songs with this title!");
                                                System.out.println("");
                                            }
                                            playlistIterator = playlist.iterator();
                                            break;
                                    case 3: System.out.println("Insert album: ");album = B.readLine();
                                            System.out.println("");
                                            while(playlistIterator.hasNext())
                                            {
                                                Song song = playlistIterator.next();
                                                if(song.getAlbum().equalsIgnoreCase(album))
                                                {
                                                    song.printSong();
                                                    found++;
                                                }
                                            }
                                            if(found > 0)
                                            {
                                                System.out.println(found+" song(s) found!");
                                                System.out.println("");
                                            }
                                            else
                                            {
                                                System.out.println("There are no songs from the specified album!");
                                                System.out.println("");
                                            }
                                            playlistIterator = playlist.iterator();
                                            break;
                                    case 4: System.out.println("Insert release year: ");release_year = Integer.parseInt(B.readLine());
                                            System.out.println("");
                                            while(playlistIterator.hasNext())
                                            {
                                                Song song = playlistIterator.next();
                                                if(song.getRelease_year() == release_year)
                                                {
                                                    song.printSong();
                                                    found++;
                                                }
                                            }
                                            if(found > 0)
                                            {
                                                System.out.println(found+" song(s) found!");
                                                System.out.println("");
                                            }
                                            else
                                            {
                                                System.out.println("There are no songs released on the inserted year!");
                                                System.out.println("");
                                            }
                                            playlistIterator = playlist.iterator();
                                            break;
                                }
                            }
                            while(input2!=0);
                        }
                        break;
                case 4: if(playlist.isEmpty())
                        {
                            System.out.println("You don't have anything in the playlist!");
                            System.out.println("");
                        }
                        else
                        {
                            playlistIterator = playlist.iterator();
                            templistIterator = templist.iterator();
                            do
                            {
                                songtemp.selectType();
                                System.out.println("Choice: ");input2 = Integer.parseInt(B.readLine());
                                System.out.println("");
                                songtemp.modifySong(input2,playlist,playlistIterator,templist,templistIterator);
                            }
                            while(input2!=0);
                        }
                        break;
                case 5: if(playlist.isEmpty())
                        {
                            System.out.println("You don't have anything in the playlist!");
                            System.out.println("");
                        }
                        else
                        {
                            playlistIterator = playlist.iterator();
                            templistIterator = templist.iterator();
                            do
                            {
                                songtemp.selectType();
                                System.out.println("Choice: ");input2 = Integer.parseInt(B.readLine());
                                System.out.println("");
                                songtemp.deleteSong(input2,playlist,playlistIterator,templist,templistIterator);
                            }
                            while(input2!=0);
                        }
                        break;
                case 6: System.out.println("Are you sure you want to load the preset playlist? This will clear your current playlist. (Y/N)");String load=B.readLine();
                        System.out.println("");
                        while(!(load.equalsIgnoreCase("Y")||(load.equalsIgnoreCase("N"))))
                        {
                            System.out.println("Are you sure you want to load the preset playlist? This will clear your current playlist. (Y/N)");load=B.readLine();
                            System.out.println("");
                        }
                        if(load.equalsIgnoreCase("Y"))
                        {
                            playlist.clear();
                            playlist.add(new Song("Sawai Miku","Gomen ne, Iiko ja Irarenai.","Yuuutsu Biyori",2013));
                            playlist.add(new Song("Uchida Maaya","North Child","PENKI",2015));
                            playlist.add(new Song("Amamiya Sora","Absolute Blue","Various BLUE",2016));
                            playlist.add(new Song("Trident","BLUE","BLUE",2016));
                            playlist.add(new Song("Ray","a-gain","Little Trip",2016));
                            playlist.add(new Song("GARNiDELiA","Yakusoku -Promise code-","Violet Cry",2016));
                            playlist.add(new Song("ClariS","Luminous","Second Story",2012));
                            playlist.add(new Song("Nanjou Yoshino","Zero Ichi Kiseki","N no Hako",2016));
                            playlist.add(new Song("Kurosaki Maon","Setsuna no Kajitsu","Mystical Flowers",2015));
                            playlist.add(new Song("fripSide","magicaride -version 2016-","infinite synthesis 3",2016));
                            playlist.add(new Song("Walkure","Ikenai Borderline","Walkure Attack!",2016));
                            playlist.add(new Song("LiSA","L.Miranic","Launcher",2015));
                            System.out.println("Successfully loaded the preset playlist!");
                            System.out.println("");
                        }
                        else if(load.equalsIgnoreCase("N"))
                        {
                            System.out.println("Cancelled loading the preset playlist!");
                            System.out.println("");
                        }
                        break;
            }
        }
        while(input!=0);
        System.out.println("Goodbye!");
    }
}