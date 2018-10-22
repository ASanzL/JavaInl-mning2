package com.company;

import java.util.ArrayList;

/**
 * En singleton klass som sparar objekt av typen Song i en arraylista
 * @author Andreas Sanz
 * @version 1.0
 * @see Song
 */

public class SongList {
    private static SongList songList = new SongList();
    private ArrayList<Song> list = new ArrayList<>();

    private SongList() {}

    public static SongList createList() {
        return songList;
    }

    /**
     * Lägger till en låt i listan
     * @param song Låten som ska läggas till i listan
     * @see SongList#addSong(Song)
     */
    public void addSong(Song song) {
        list.add(song);
    }

    /**
     * Skriver ut alla låtar i listan
     * @see SongList#showList()
     */
    public void showList() {
        if(list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(i + " - ");
                list.get(i).showSong();
            }
        } else {
            System.out.println("Listan är tom.");
        }
    }

    /**
     * Ändrar en låt i listan om index finns
     * @param index Index på låten.
     */
    public void editSong(int index) {
        if(index < 0 || index > list.size()-1) {
            System.out.println("Ej gilltigt index");
            return;
        }
        list.get(index).initSong();
    }

    /**
     * Tar bort en låt i listan om index finns
     * @param index Index på låten.
     */
    public void deleteSong(int index) {
        if(index < 0 || index > list.size()) {
            System.out.println("Ej gilltigt index");
            return;
        }
        System.out.println(list.remove(index) + " har raderats");
    }
}
