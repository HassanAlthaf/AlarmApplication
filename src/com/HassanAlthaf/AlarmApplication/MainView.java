/*
 * Program developed by Hassan Althaf.
 * Copyright © 2015, Hassan Althaf.
 * Website: http://hassanalthaf.com
 */
package com.HassanAlthaf.AlarmApplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 *
 * @author hassan
 */
public class MainView implements Initializable {
    
    @FXML
    private TextField hoursField;
    
    @FXML
    private TextField minutesField;
    
    @FXML
    private TextField secondsField;
    
    private final AlarmController alarmController;
    
    @FXML
    private void startAlarm(ActionEvent event) {
        int response = this.alarmController.startAlarm(
            this.hoursField.getText(), 
            this.minutesField.getText(),
            this.secondsField.getText()
        );
        
        if (response == Alarm.ERROR_INVALID_INPUT) {
            this.showWarning("Please enter a number only for the times!", "Invalid input received");
        } else if (response == Alarm.ERROR_ALARM_ALREADY_ON) {
            this.showWarning("An alarm is already running at the moment! If you wish to override the current alarm, please stop it first!", "Cannot override current alarm.");
        } else if (response == Alarm.ERROR_NO_TIME_SET) {
            this.showWarning("You cannot set an alarm for 0 seconds! Please set a realistic time.", "No time set");
        } else {
            this.showSuccessfulMessage("Successfully scheduled alarm!", "Success");
        }
    }
    
    public void showWarning(String message, String title) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public void showSuccessfulMessage(String message, String title) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
   
    @FXML
    private void stopAlarm(ActionEvent event) {
        this.alarmController.stopAlarm();
        
        this.showSuccessfulMessage("Successfully stopped the alarm!", "Success");
    }
    
    
    public MainView() {
        this.alarmController = new AlarmController();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}