package com.company.DesignPattern;

public class Mp4Player implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {

    }

    public void playMp4(String fileName) {
        System.out.println("Mp4 file: " + fileName + " is playing...");
    }
}
