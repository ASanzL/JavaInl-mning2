package com.company;

import java.util.Scanner;

/**
 * Ger alternativ om att lägga till, visa, ändra och ta bort låtar i en lista.
 * @author Andreas Sanz
 * @see SongList
 */
public class Main {
    static SongList songList = SongList.createList();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

	    showOptions();

        boolean quit = false;

        while (!quit) {
            System.out.print("Val: ");
            int option = 0;
            option = makeOption();

            switch (option) {
                case 1:
                    showOptions();
                    break;
                case 2:
                    addSong();
                    break;
                case 3:
                    showSongs();
                    break;
                case 4:
                    editSong();
                    break;
                case 5:
                    deleteSong();
                    break;
                case 6:
                    addFavorite();
                    break;
                case 7:
                    showFavorites();
                    break;
                default:
                    quit = true;
                    break;
            }
        }
    }

    /**
     * Skriver ut de val man kan göra
     */
    static void showOptions() {
        System.out.println("1 - Visa val.\n" +
                "2 - Lägg till ny låt.\n" +
                "3 - Visa alla låtar.\n" +
                "4 - Ändra låt.\n" +
                "5 - Ta bort låt.\n" +
                "6 - Lägg till favorit.\n" +
                "7 - Visa alla favoriter.\n" +
                "8 - Avsluta program.\n");
    }

    /**
     * Lägger till en ny låt i listan
     */
    static void addSong() {
        System.out.println("1 - Studiolåt\n2 - Livelåt");

        switch (makeOption()) {
            case 1:
                songList.addSong(new StudioSong());
                break;
            case 2:
                songList.addSong(new LiveSong());
                break;
            default:
                System.out.println("Ej gilltigt val");
                return;

        }
    }

    /**
     * Visar alla låtar i listan
     */
    static void showSongs() {
        songList.showAllSongs();
    }

    /**
     * Låter användaren skriva ett tal
     * @return Det tal användaren skriver in, om användaren inte skriver inte ett tal så returneras -1
     */
    static int makeOption() {
        int option = -1;
        try {
            option = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
        return option;
    }

    /**
     * Ändra en låt
     * @see SongList#editSong(int)
     */
    static void editSong() {
        System.out.print("Låt nummer: ");

        songList.editSong(makeOption());
    }

    /**
     * Ta bort en låt
     * @see SongList#deleteSong(int)
     */
    static void deleteSong() {
        System.out.print("Låt nummer: ");

        songList.deleteSong(makeOption());
    }

    /**
     * Lägg till favoritlåt.
     */
    static void addFavorite() {
        System.out.print("Låt nummer: ");

        songList.addFavorite(makeOption());
    }

    /**
     * Visar favoritlåtar.
     */
    static void showFavorites() {
        songList.showFavorites();
    }
}
