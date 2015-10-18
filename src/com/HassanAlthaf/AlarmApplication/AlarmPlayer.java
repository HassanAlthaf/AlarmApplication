/*
 * Program developed by Hassan Althaf.
 * Copyright © 2015, Hassan Althaf.
 * Website: http://hassanalthaf.com
 */
package com.HassanAlthaf.AlarmApplication;

import java.util.concurrent.atomic.AtomicBoolean;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author hassan
 */
public class AlarmPlayer {
    private MediaPlayer mediaPlayer;
    
    private AtomicBoolean state = new AtomicBoolean();
    
    public void play()
    {
        Media media = new Media(getClass().getResource("alarm.mp3").toString());
        this.mediaPlayer = new MediaPlayer(media);
        
        this.mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                setState(false);
            }
        });
        
        this.mediaPlayer.play();
        this.setState(true);
    }
    
    public void stop()
    {
        this.mediaPlayer.stop();
        this.setState(false);
    }
    
    public boolean getState() {
        return this.state.get();
    }
    
    public void setState(boolean state) {
        this.state.set(state);
    }
}
