package com.company;

import java.util.ArrayList;

public class SongList {
    private static SongList songList = new SongList();
    private ArrayList<Song> list = new ArrayList<>();

    private SongList() {}

    public static SongList createList() {
        return songList;
    }

    public void addSong() {
        Song song = new StudioSong();
        list.add(song);
    }

    public void showList() {
        for(int i = 0 ; i < list.size(); i++) {
            list.get(i).showSong();
        }
    }
}
