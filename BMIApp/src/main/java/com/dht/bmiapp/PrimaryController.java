package com.dht.bmiapp;

import com.dht.services.BMIService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class PrimaryController {
    @FXML private TextField txtWeight;
    @FXML private TextField txtHeight;
    @FXML private Label lblResult;
    
    public void tinhBmiHandler(ActionEvent evt) {
        double w = Double.parseDouble(this.txtWeight.getText());
        double h = Double.parseDouble(this.txtHeight.getText());
        int r = BMIService.tinhBMI(w, h);
        
        if (r == 0) {
            this.lblResult.setText("Gầy");
            this.lblResult.setTextFill(Color.RED);
        } else {
            this.lblResult.setText("Bình thường");
            this.lblResult.setTextFill(Color.BLUE);
        }
    }
}
