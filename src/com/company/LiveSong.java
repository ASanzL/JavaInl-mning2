package com.company;

/**
 * Ärver från Song
 */
public class LiveSong extends Song {

    private String location;
    private int audienceNumber;

    public LiveSong() {
        super();

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

    @Override
    public void showSong() {
        super.showSong();
        System.out.println("Plats: " + location + "\n" +
                "Publik: " + audienceNumber + "\n");
    }
}
