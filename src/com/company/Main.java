package com.company;

import java.util.Scanner;

/**
 * Ger alternativ om att lägga till, visa, ändra och ta bort låtar i en lista.
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

            try {
                option = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ej gilltigt val.\n");
                option = 1;
            }

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
                    editSong(makeOption());
                    break;
                case 5:
                    deleteSong(makeOption());
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
                "5 - Ta bort låt.\n");
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
        songList.showList();
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
     * @param index Index på låten i listan
     */
    static void editSong(int index) {
        System.out.print("Låt nummer: ");

        songList.editSong(index);
    }

    /**
     * Ta bort en låt
     * @param index Index på låten i listan
     */
    static  void deleteSong(int index) {
        System.out.print("Låt nummer: ");

        songList.deleteSong(index);
    }
}
