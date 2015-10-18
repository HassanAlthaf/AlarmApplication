/*
 * Program developed by Hassan Althaf.
 * Copyright © 2015, Hassan Althaf.
 * Website: http://hassanalthaf.com
 */
package com.HassanAlthaf.AlarmApplication;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class AlarmTimer {
    private AtomicBoolean timerValidation = new AtomicBoolean(true);
    private AtomicBoolean timerOn = new AtomicBoolean();
    private final AlarmPlayer alarmPlayer;
    private Timer timer;
    
    public AlarmTimer(AlarmPlayer alarmPlayer) {
        this.alarmPlayer = alarmPlayer;
    }
    
    public void start(Alarm alarm) {
        this.timer = new Timer();
        
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(!alarmPlayer.getState()) {
                    alarmPlayer.play();
                    alarmPlayer.setState(true);
                }
                
                setTimer(false);
            }
        };
        
        this.timer.schedule(timerTask, alarm.getTimeInMilliseconds());
        this.setTimer(true);
    }
    
    public void stop() {
        this.timer.cancel();
        this.timer.purge();
        this.setTimer(false);
    }
    
    public boolean isTimerOn()
    {
        return this.timerOn.get();
    }
    
    public void setTimer(boolean state)
    {
        this.timerOn.set(state);
    }
    
    public boolean isValid()
    {
        return this.timerValidation.get();
    }
    
    public void setValidationState(boolean state)
    {
        this.timerValidation.set(state);
    }
}
