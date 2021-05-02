package com.example.camera;

import android.media.MediaPlayer;

public class MusicPlayer implements MediaPlayer.OnCompletionListener {
    MediaPlayer player;
    private MusicService musicService;
    int musicStatus = 0;
    int musicIndex = 0;

    static final int MUSICPATH = R.raw.pencilsound;
    /**
    static final int[] MUSICPATH = new int[]{
            R.raw.pencilsound,
    };

    static final String[] MUSICNAME = new String[]{
            "Pencil Sound"
    };
     **/

    public MusicPlayer(MusicService service) {

        this.musicService = service;
    }

    public int getMusicStatus() {

        return musicStatus;
    }


    public void playMusic() {
        player = MediaPlayer.create(this.musicService, MUSICPATH);
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
            playMusic();
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }
}
