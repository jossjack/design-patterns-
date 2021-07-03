/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronstate;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author joseph
 */
public class MessageProcess {

    private Thread sendThread;
    private final Server server;
    private final Queue<String> messageQueue = new LinkedList<>();

    public MessageProcess(Server server) {
        this.server = server;
    }

    public boolean queueMessage(String message) {
        if (messageQueue.size() >= server.getMaxRequest()) {
            System.out.println("Requests reached maximum ("
                    + messageQueue.size() + ")");
            return false;
        }
        messageQueue.add(message);
        System.out.println("Queue message ("
                + messageQueue.size() + ")");
        return true;
    }

    public int countMessage() {
        return messageQueue.size();
    }

    public void start() {
        this.sendThread = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000 * 10);
                        if (!messageQueue.isEmpty()) {
                            String message = messageQueue.poll();
                            System.out.println("Message process > " + message + "(" + messageQueue.size() + ")");
                        }
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        this.sendThread.start();
    }

    public void stop() {
        if (this.sendThread != null) {
            this.sendThread.stop();
            this.sendThread = null;
        }
    }
}
