package com.company;

import java.util.Scanner;

public abstract class Song {
    private String name;
    private int length;
    private String band;
    private String genre;
    private String album;

    private static Scanner scan = new Scanner(System.in);

    public Song() {
        initSong();
    }

    public Song(String name, int length, String band, String genre, String album) {
        this.name = name;
        this.length = length;
        this.band = band;
        this.genre = genre;
        this.album = album;
    }

    public void initSong() {
        System.out.print("Namne: ");
        String name = scan.nextLine();

        /*System.out.print("Längd(sekunder): ");
        int length = scan.nextInt();
*/
        System.out.print("Band: ");
        String band = scan.nextLine();

        System.out.print("Genre: ");
        String genre = scan.nextLine();

        System.out.print("Album: ");
        String album = scan.nextLine();
    }

    public void showSong() {
        System.out.println("Namn: " + name + "\n" +
                "Längd: " + formatLength() + "\n" +
                "Band: " + band + "\n" +
                "Genre: " + genre + "\n" +
                "Album: " + album);
    }

    private String formatLength() {
        return (int)Math.floor(length/60) + ":" + String.format("%02d", length%60);
    }
}
