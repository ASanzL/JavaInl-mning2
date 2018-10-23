package com.company;

/**
 * @author Andreas Sanz
 * Ärver från {@link Song}
 */
public class StudioSong extends Song {
    private String studio;

    public StudioSong() {
        initSong();
    }

    /**
     * @see Song#initSong()
     */
    @Override
    public void initSong() {
        super.initSong();

        System.out.print("Studio: ");
        this.studio = scan.nextLine();
    }

    public StudioSong(String name, int length, String band, String genre, String album, String studio) {
        super(name, length, band, genre, album);
        this.studio = studio;
    }

    /**
     * @see Song#showSong()
     */
    @Override
    public void showSong() {
        super.showSong();
        System.out.println("Studio: " + studio + "\n");
    }
}
