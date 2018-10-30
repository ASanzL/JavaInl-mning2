package com.company;

import java.util.ArrayList;

/**
 * En singleton klass som sparar objekt av typen Song i en arraylista
 * @author Andreas Sanz
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
     * Skriver ut alla låtar i listan.
     * @param list Lista att visa.
     * @see Song#showSong()
     */
    private void showList(ArrayList<Song> list) {
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
     * Skriver ut alla låtar
     * @see SongList#showList(ArrayList)
     */
    public void showAllSongs() {
        showList(list);
    }

    /**
     * Skriver ut alla favoritlåtar
     * @see SongList#showList(ArrayList)
     */
    public void showFavorites() {
        showList(getFavorites());
    }

    /**
     * Hämtar alla låtar som är favoriter.
     * @return Favoritlåtar i lista.
     */
    private ArrayList<Song> getFavorites() {
        ArrayList<Song> list = new ArrayList<>();
        if(this.list.size() > 0) {
            for (int i = 0; i < this.list.size(); i++) {
                if(this.list.get(i).isFavorite()) {
                    list.add(this.list.get(i));
                }
            }
        }
        return list;
    }

    /**
     * Ändrar en låt i listan om index finns
     * @param index Index på låten.
     */
    public void editSong(int index) {
        if(!indexIsValid(index)) {
            System.out.println("Ej gilltigt index");
            return;
        }
        list.get(index).initSong();
    }

    /**
     * Tar bort en låt i listan om index finns.
     * @param index Index på låten.
     */
    public void deleteSong(int index) {
        if(!indexIsValid(index)) {
            System.out.println("Ej gilltigt index");
            return;
        }
        System.out.println(list.remove(index) + " har raderats");
    }

    /**
     * Lägger till en favoritlåt.
     * @param index Index på låten.
     */
    public void addFavorite(int index) {
        if(!indexIsValid(index)) {
            System.out.println("Ej gilltigt index");
            return;
        }
        list.get(index).setFavorite(true);
    }

    /**
     *
     * @param index index i listan
     * @return Returnerar true om index är ett godkänt index i listan
     */
    private boolean indexIsValid(int index) {
        return !(index < 0 || index > list.size()-1);
    }
}
