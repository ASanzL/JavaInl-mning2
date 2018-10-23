package com.company;

import java.util.Scanner;

/**
 * En abstrakt klass för en låt.
 * @author Andreas Sanz
 * @see StudioSong
 * @see LiveSong
 */
public abstract class Song {
    private String name;
    private int length;
    private String band;
    private String genre;
    private String album;

    protected static Scanner scan = new Scanner(System.in);

    /**
     * Konstruktor för att skapa en låt med användaren.
     * @see #initSong()
     */
    public Song() {

    }

    /**
     * Konstruktor för att skapa en låt från parametrar.
     * @param name Namn på låten.
     * @param length Längden på låten i sekunder.
     * @param band Bandet som gjort låten.
     * @param genre Genren på låten.
     * @param album Låtens album.
     */
    public Song(String name, int length, String band, String genre, String album) {
        this.name = name;
        this.length = length;
        this.band = band;
        this.genre = genre;
        this.album = album;
    }

    /**
     * Låter användaren fylla i låtens info.
     */
    public void initSong() {
        System.out.print("Namn: ");
        this.name = scan.nextLine();

        System.out.print("Längd(sekunder): ");
        try {
            this.length = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            this.length = 150;
        }

        System.out.print("Band: ");
        this.band = scan.nextLine();

        System.out.print("Genre: ");
        this.genre = scan.nextLine();

        System.out.print("Album: ");
        this.album = scan.nextLine();
    }

    /**
     * Skriver ut all info om låten.
     */
    public void showSong() {
        System.out.print("Namn: " + name + ",\t" +
                "Längd: " + formatLength(length) + ",\t" +
                "Band: " + band + ",\t" +
                "Genre: " + genre + ",\t" +
                "Album: " + album + ",\t");
    }

    /**
     * Gör om sekunder till minuter och sekunder.
     * @param length Tiden i sekunder
     * @return Låt längd formaterad
     */
    private String formatLength(int length) {
        return (int)Math.floor(length/60) + ":" + String.format("%02d", length%60);
    }

    /**
     *
     * @return Låtens namn.
     */
    @Override
    public String toString() {
        return name;
    }
}
