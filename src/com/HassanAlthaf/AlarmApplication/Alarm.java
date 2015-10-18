package com.HassanAlthaf.AlarmApplication;

/*
 * Program developed by Hassan Althaf.
 * Copyright © 2015, Hassan Althaf.
 * Website: http://hassanalthaf.com
 */

/**
 *
 * @author hassan
 */
public class Alarm {
    public final static int SUCCESS = 1;
    public final static int ERROR_INVALID_INPUT = 2;
    public final static int ERROR_ALARM_ALREADY_ON = 3;
    public final static int ERROR_NO_TIME_SET = 4;
    
    private int hours;
    private int minutes;
    private int seconds;
    
    public int getHours() {
        return this.hours;
    }
    
    public void setHours(int hours)
    {
        this.hours = hours;
    }
    
    public int getMinutes() {
        return this.minutes;
    }
    
    public void setMinutes(int minutes)
    {
        this.minutes = minutes;
    }
    
    public int getSeconds() {
        return this.seconds;
    }
    
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    
    public long getTimeInMilliseconds() {
        return ((hours * 3600) + (minutes * 60) + seconds) * 1000;
    }
}
