/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patrontemplatemethod.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class OnMemoryDataBase {

    public static final Map<String, String> PROCESS_DOCUMENTS = new HashMap<>();
    public static final int[] CUSTOMERS = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    public static String getFileStatus(String fileName) {
        if (PROCESS_DOCUMENTS.containsKey(fileName)) {
            return PROCESS_DOCUMENTS.get(fileName);
        }
        return null;
    }

    public static void setProcessFile(String fileName) {
        PROCESS_DOCUMENTS.put(fileName, "Processed");
    }

    public static boolean customerExist(int id) {
        for (int i : CUSTOMERS) {
            if (i == id) {
                return true;
            }
        }
        return false;
    }
}
