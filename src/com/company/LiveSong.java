package com.company;

/**
 * @author Andreas Sanz
 * Ärver från {@link Song}
 */
public class LiveSong extends Song {

    private String location;
    private int audienceNumber;

    public LiveSong() {
        initSong();
    }

    /**
     * @see Song#initSong()
     */
    @Override
    public void initSong() {
        super.initSong();

        System.out.print("Plats: ");
        this.location = scan.nextLine();

        System.out.print("Publik: ");
        try {
            this.audienceNumber = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            this.audienceNumber = 0;
        }
    }

    public LiveSong(String name, int length, String band, String genre, String album, String location, int audienceNumber) {
        super(name, length, band, genre, album);
        this.location = location;
        this.audienceNumber = audienceNumber;
    }

    /**
     * @see Song#showSong()
     */
    @Override
    public void showSong() {
        super.showSong();
        System.out.println("Plats: " + location + "\n" +
                "Publik: " + audienceNumber + "\n");
    }
}
