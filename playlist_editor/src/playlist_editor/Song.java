/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlist_editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import static playlist_editor.Main.B;

/**
 *
 * @author Hinsvar
 */
public class Song {
    private String artist;
    private String title;
    private String album;
    private int release_year;
    
    public Song ()
    {
        
    }
    
    public Song (String artist, String title, String album, int release_year)
    {
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.release_year = release_year;
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the release_year
     */
    public int getRelease_year() {
        return release_year;
    }

    /**
     * @param release_year the release_year to set
     */
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    /**
     * @return the album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * @param album the album to set
     */
    public void setAlbum(String album) {
        this.album = album;
    }
    
    public Song inputSong() throws IOException
    {
        String artist, title, album;
        int release_year;
        System.out.println("Artist: ");artist = B.readLine();
        while(artist.equals(""))
        {
            System.out.println("You must insert an artist!");
            System.out.println("Artist: ");artist = B.readLine();
            System.out.println("");
        }
        System.out.println("Title: ");title = B.readLine();
        while(title.equals(""))
        {
            System.out.println("You must insert a title!");
            System.out.println("Title: ");title = B.readLine();
            System.out.println("");
        }
        System.out.println("Album: ");album = B.readLine();
        while(album.equals(""))
        {
            System.out.println("You must insert the album title!");
            System.out.println("Album: ");album = B.readLine();
            System.out.println("");
        }
        System.out.println("Release year: ");release_year = Integer.parseInt(B.readLine());
        while(String.valueOf(release_year).equals(""))
        {
            System.out.println("You must insert the release year!");
            System.out.println("Release year: ");release_year = Integer.parseInt(B.readLine());
            System.out.println("");
        }
        return new Song(artist,title,album,release_year);
    }
    
    public void printSong()
    {
        System.out.println("Artist: "+getArtist());
        System.out.println("Title: "+getTitle());
        System.out.println("Album: "+getAlbum());
        System.out.println("Release year: "+getRelease_year());
        System.out.println("");
    }
    
    public void selectType()
    {
        System.out.println("[1] Find by artist");
        System.out.println("[2] Find by title");
        System.out.println("[3] Find by album");
        System.out.println("[4] Find by release year");
        System.out.println("[0] Cancel");
    }
    
    public void inputType(int choice, ArrayList<Song> playlist, Iterator playlistIterator, ArrayList<Song> templist) throws IOException
    {
        String artist, title, album;
        int release_year;
        Song song;
        playlistIterator = playlist.iterator();
        switch(choice)
        {
            case 1: System.out.println("Insert artist: ");artist = B.readLine();
                    System.out.println("");
                    while(playlistIterator.hasNext())
                    {
                        song = (Song) playlistIterator.next();
                        if(song.getArtist().equalsIgnoreCase(artist))
                        {
                            templist.add(song);
                        }
                    }
                    break;
            case 2: System.out.println("Insert title: ");title = B.readLine();
                    System.out.println("");
                    while(playlistIterator.hasNext())
                    {
                        song = (Song) playlistIterator.next();
                        if(song.getTitle().equalsIgnoreCase(title))
                        {
                            templist.add(song);
                        }
                    }
                    break;
            case 3: System.out.println("Insert album: ");album = B.readLine();
                    System.out.println("");
                    while(playlistIterator.hasNext())
                    {
                        song = (Song) playlistIterator.next();
                        if(song.getAlbum().equalsIgnoreCase(album))
                        {
                            templist.add(song);
                        }
                    }
                    break;
            case 4: System.out.println("Insert release year: ");release_year = Integer.parseInt(B.readLine());
                    System.out.println("");
                    while(playlistIterator.hasNext())
                    {
                        song = (Song) playlistIterator.next();
                        if(song.getRelease_year() == release_year)
                        {
                            templist.add(song);
                        }
                    }
                    break;
        }
    }
    
    public void modifySong(int choice, ArrayList<Song> playlist, Iterator playlistIterator, ArrayList<Song> templist, Iterator templistIterator) throws IOException
    {
        Song song, songtemp;
        inputType(choice, playlist, playlistIterator, templist);
        System.out.println(templist.size()+" song(s) found!");
        if(choice!=0)
        {
            if(templist.size() > 1)
            {
                int i=0,choice2;
                templistIterator = templist.iterator();
                while(templistIterator.hasNext())
                {
                    i++;
                    song = (Song) templistIterator.next();
                    System.out.println("Song "+i);
                    song.printSong();
                }
                System.out.println(templist.size()+" song(s) found! Which song will you modify? (Insert the number corresponding to the song)");choice2=Integer.parseInt(B.readLine());
                System.out.println("");
                while(choice2 > templist.size() || choice2 <= 0)
                {
                    System.out.println("Invalid number! Choose the number of the song that you want to modify: ");choice2=Integer.parseInt(B.readLine());
                    System.out.println("");
                }
                templist.get(choice2-1).printSong();
                songtemp = inputSong();
                playlistIterator = playlist.iterator();
                while(playlistIterator.hasNext())
                {
                    song = (Song) playlistIterator.next();
                    if(song.equals(templist.get(choice2-1)))
                    {
                        playlist.set(playlist.indexOf(templist.get(choice2-1)),songtemp);
                        System.out.println("Song modification successful!");
                        System.out.println("");
                        break;
                    }
                }
            }
            else if (templist.size() == 1)
            {
                templist.get(0).printSong();
                System.out.println("Song modification: ");
                System.out.println("");
                songtemp = inputSong();
                playlistIterator = playlist.iterator();
                while(playlistIterator.hasNext())
                {
                    song = (Song) playlistIterator.next();
                    if(song.equals(templist.get(0)))
                    {
                        playlist.set(playlist.indexOf(templist.get(0)),songtemp);
                        System.out.println("Song modification successful!");
                        System.out.println("");
                        break;
                    }
                }
            }
            else if (templist.isEmpty())
            {
                System.out.println("No songs found with this criteria!");
                System.out.println("");
            }
            templist.clear();
        }
    }
    
    public void deleteSong(int choice, ArrayList<Song> playlist, Iterator playlistIterator, ArrayList<Song> templist, Iterator templistIterator) throws IOException
    {
        Song song;
        inputType(choice, playlist, playlistIterator, templist);
        if(choice!=0)
        {
            if(templist.size() > 1)
            {
                int i=0,choice2;
                templistIterator = templist.iterator();
                while(templistIterator.hasNext())
                {
                    i++;
                    song = (Song) templistIterator.next();
                    System.out.println("Song "+i);
                    song.printSong();
                }
                System.out.println(templist.size()+" song(s) found! Which song will you remove? (Insert the number corresponding to the song)");choice2=Integer.parseInt(B.readLine());
                System.out.println("");
                while(choice2 > templist.size() || choice2 <= 0)
                {
                    System.out.println("Invalid number! Choose the number of the song that you want to remove: ");choice2=Integer.parseInt(B.readLine());
                    System.out.println("");
                }
                templist.get(choice2-1).printSong();
                playlistIterator = playlist.iterator();
                while(playlistIterator.hasNext())
                {
                    song = (Song) playlistIterator.next();
                    if(song.equals(templist.get(choice2-1)))
                    {
                        playlist.remove(playlist.indexOf(templist.get(choice2-1)));
                        System.out.println("Song removal successful!");
                        System.out.println("");
                        break;
                    }
                }
            }
            else if (templist.size() == 1)
            {
                templist.get(0).printSong();
                playlistIterator = playlist.iterator();
                while(playlistIterator.hasNext())
                {
                    song = (Song) playlistIterator.next();
                    if(song.equals(templist.get(0)))
                    {
                        playlist.remove(playlist.indexOf(templist.get(0)));
                        System.out.println("Song removal successful!");
                        System.out.println("");
                        break;
                    }
                }
            }
            else if (templist.isEmpty())
            {
                System.out.println("No songs found with this criteria!");
                System.out.println("");
            }
            templist.clear();
        }
    }
}
