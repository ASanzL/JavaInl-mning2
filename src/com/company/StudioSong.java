package com.company;

/**
 * Ärver från Song
 */
public class StudioSong extends Song {
    private String studio;

    public StudioSong() {
        super();

        System.out.print("Studio: ");
        this.studio = scan.nextLine();
    }

    public StudioSong(String name, int length, String band, String genre, String album, String studio) {
        super(name, length, band, genre, album);
        this.studio = studio;
    }

    @Override
    public void showSong() {
        super.showSong();
        System.out.println("Studio: " + studio + "\n");
    }
}
