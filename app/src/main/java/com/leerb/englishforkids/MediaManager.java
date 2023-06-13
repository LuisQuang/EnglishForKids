package com.leerb.englishforkids;

import android.media.MediaPlayer;

public class MediaManager {
    private static MediaManager instance;
    private MediaPlayer playBGMusic;
    private MediaPlayer playGameMusic;
    private boolean isBGMusicPlaying;
    private boolean isGameMusicPlaying;

    private MediaManager() {
    }

    public static MediaManager getInstance() {
        if (instance == null) {
            instance = new MediaManager();
        }
        return instance;
    }

    public void playBGMusic(int song) {
        if (playBGMusic != null) {
            playBGMusic.reset();
        }
        try {
            playBGMusic = MediaPlayer.create(App.getInstance(), song);
            playBGMusic.setLooping(true);
            playBGMusic.start();
            isBGMusicPlaying = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playGameMusic(int song, MediaPlayer.OnCompletionListener event) {
        if (playGameMusic != null) {
            playGameMusic.reset();
        }
        try {
            playGameMusic = MediaPlayer.create(App.getInstance(), song);
            playGameMusic.setOnCompletionListener(event);
            playGameMusic.setLooping(false);
            playGameMusic.start();
            isGameMusicPlaying = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pauseSong() {
        if (playBGMusic != null && isBGMusicPlaying) {
            playBGMusic.pause();
            isBGMusicPlaying = false;
        }
        if (playGameMusic != null && isGameMusicPlaying) {
            playGameMusic.pause();
            isGameMusicPlaying = false;
        }
    }

    public void playSong() {
        if (playGameMusic != null && !isGameMusicPlaying) {
            isGameMusicPlaying = true;
            playGameMusic.start();
        }
        if (playBGMusic != null && !isBGMusicPlaying) {
            isBGMusicPlaying = true;
            playBGMusic.start();
        }
    }

    public void stopBG() {
        if (playBGMusic != null) {
            playBGMusic.reset();
            isBGMusicPlaying = false;
        }
    }

    public void stopMusic() {
        if (playGameMusic != null) {
            playGameMusic.reset();
            isGameMusicPlaying = false;
        }
    }
}
