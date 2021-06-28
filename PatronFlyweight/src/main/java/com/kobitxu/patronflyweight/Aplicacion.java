/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronflyweight;

import com.kobitxu.patronflyweight.impl.PlayItemFactory;
import com.kobitxu.patronflyweight.impl.PlayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    private static final String[] songNames = new String[1000];
    private static final String[] playListNames = new String[4100000];
    private static final List<PlayList> playLists = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(""
                + "Playlist creation process started, this process can be\n"
                + "very delayed due to the large amount of objects that \n"
                + "will be created, please wait a moment until you \n"
                + "are notified that the process has finished.");

        Runtime runtime = Runtime.getRuntime();
        System.out.println("MaxMemory > " + (runtime.maxMemory() / 1000000));
        PlayItemFactory.enableFlyweight = true;
        initArrays();
        createRandonPlayList();

        System.out.println("total playlist > " + playLists.size());

        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory Used => " + (memoryUsed / 1000000));//
    }

    private static void createRandonPlayList() {
        Random random = new Random();
        int p = 0;
        for (int c = 0; c < playListNames.length; c++) {
            PlayList playList = new PlayList(playListNames[c]);
            for (int i = 0; i < 10; i++) {
                int song = random.nextInt(songNames.length);
                playList.addPlayItem(songNames[song]);
            }
            playLists.add(playList);
            if (c != 0 && (c + 1) % (playListNames.length / 10) == 0) {
                p += 10;
                System.out.println("Completed " + p + "%");
                System.out.println("Lists created " + playLists.size());
            }
        }
    }

    private static void initArrays() {
        for (int c = 0; c < songNames.length; c++) {
            songNames[c] = "Song " + (c + 1);
        }

        for (int c = 0; c < playListNames.length; c++) {
            playListNames[c] = "PlayList " + (c + 1);
        }
    }

}
