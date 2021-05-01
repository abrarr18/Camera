package com.example.camera;

import android.media.MediaPlayer;

public class MusicPlayer implements MediaPlayer.OnCompletionListener {
    MediaPlayer player;
    private MusicService musicService;
    int musicStatus = 0;
    int musicIndex = 0;
    static final int[] MUSICPATH = new int[]{
            R.raw.pencilsound,
    };

    static final String[] MUSICNAME = new String[]{
            "Pencil Sound"

    };

    public MusicPlayer(MusicService service) {

        this.musicService = service;

    }


    public int getMusicStatus() {

        return musicStatus;
    }

    public String getMusicName() {

        return MUSICNAME[musicIndex];
    }

    public int getIndex(String str) {
        for (int i = 0; i < MUSICNAME.length; i++) {
            if (str.compareTo(MUSICNAME[i]) == 0) {
                //musicIndex=i;
                return i;
            }

        }
        return -1;
    }

    public void playMusic(int index) {
        musicIndex = index;
        player = MediaPlayer.create(this.musicService, MUSICPATH[musicIndex]);
        player.start();
        player.setOnCompletionListener(this);
    }
    public void pauseMusic() {
        if (player.isPlaying()){
            player.pause();
        }
    }

    public void resumeMusic(){
        if(player.isPlaying()){
            player.pause();
        }
        else{
            playMusic(1);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }
}
