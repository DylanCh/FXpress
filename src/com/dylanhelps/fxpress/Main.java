package com.dylanhelps.fxpress;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FXpress - Your Personal Forex Expert");
        primaryStage.setScene(new Scene(root, 300, 275));
        try {
            primaryStage.getScene().getStylesheets().add(
                    //"./bootstrap.min.css"
                    getClass().getResource("bootstrap.min.css").toExternalForm()
            );
        }
        catch(NullPointerException ne){
            System.err.println("Can;t load CSS");
        }
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
