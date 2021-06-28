/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronflyweight.impl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public class PlayList {

    private String playListName;
    private List<PlayItem> playItems = new ArrayList<>();

    public PlayList(String playListName) {
        this.playListName = playListName;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public List<PlayItem> getPlayItems() {
        return playItems;
    }

    public void setPlayItems(List<PlayItem> playItems) {
        this.playItems = playItems;
    }

    public void addPlayItem(String songName) {
        playItems.add(PlayItemFactory.createPlayItem(songName));
    }

    public void printList() {
        String out = "\nPlayList > " + playListName;
        out = playItems.stream()
                .map((playItem) -> "\n\t" + playItem.toString())
                .reduce(out, String::concat);
        System.out.println(out);
    }
}
