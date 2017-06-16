package com.dylanhelps.fxpress;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private TextField fromEditText;

    @FXML
    private TextField toEditText;

    @FXML
    private Button searchBtn;

    @FXML
    private TextArea displayResult;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleSearch(ActionEvent event){
        ExchangeRate exchangeRate = new ExchangeRate(fromEditText.getText(),toEditText.getText());
        exchangeRate.findExchangeRate();
        String result = exchangeRate.extractRate();
        displayResult.setText(result);
    }
}
