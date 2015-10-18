/*
 * Program developed by Hassan Althaf.
 * Copyright © 2015, Hassan Althaf.
 * Website: http://hassanalthaf.com
 */
package com.HassanAlthaf.AlarmApplication;

public class AlarmController {
    private final Alarm alarm;
    private final AlarmPlayer alarmPlayer;
    private final AlarmTimer alarmTimer;
    
    public int startAlarm(String hours, String minutes, String seconds) {
        int temporaryStorage = 0;
        int response = Alarm.SUCCESS;
        
        this.alarmTimer.setValidationState(true);
        
        temporaryStorage = this.convertTimeToInteger(hours);
        
        if(this.isValidTime(temporaryStorage)) {
            this.alarm.setHours(this.convertTimeToInteger(hours));
        } else {
            response = Alarm.ERROR_INVALID_INPUT;
        }
        
        temporaryStorage = this.convertTimeToInteger(minutes);
        
        if(this.isValidTime(temporaryStorage)) {
            this.alarm.setMinutes(temporaryStorage);
        } else {
            response = Alarm.ERROR_INVALID_INPUT;
        }
        
        temporaryStorage = this.convertTimeToInteger(seconds);
        
        if(this.isValidTime(temporaryStorage)) {
            this.alarm.setSeconds(temporaryStorage);
        } else {
            response = Alarm.ERROR_INVALID_INPUT;
        }
        
        if(this.alarmPlayer.getState() || this.alarmTimer.isTimerOn()) {
            response = Alarm.ERROR_ALARM_ALREADY_ON;
        }
        
        if(alarm.getTimeInMilliseconds() == 0) {
            response = Alarm.ERROR_NO_TIME_SET;
        }
        
        if(response == Alarm.SUCCESS) {
            this.alarmTimer.start(this.alarm);
        }
        
        return response;
    }
    
    public void stopAlarm() {
        if(this.alarmTimer.isTimerOn()) {
            this.alarmTimer.stop();
        }
        
        if(this.alarmPlayer.getState()) {
            this.alarmPlayer.stop();
        }
    }
    
    private int convertTimeToInteger(String stringMagnitude) {
        if(stringMagnitude.equals("")) {
            stringMagnitude = "0";
        }
        
        try {
            int integerMagnitude = Integer.parseInt(stringMagnitude);
            return integerMagnitude;
        } catch(NumberFormatException exception) {
            this.alarmTimer.setValidationState(false);
            return -1;
        }
    }
    
    private boolean isValidTime(int time) {
        if(time == -1) {
            return false;
        }
        
        return true;
    }
    
    public AlarmController() {
        this.alarm = new Alarm();
        this.alarmPlayer = new AlarmPlayer();
        this.alarmTimer = new AlarmTimer(this.alarmPlayer);
    }
}
