package com.company.DesignPattern;

public class VlcPlayer implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Vlc file: " + fileName + " is playing...");
    }

    public void playMp4(String fileName) {
    }
}
