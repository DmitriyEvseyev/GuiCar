package com.dmitriyevseyev.gui_car;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        stage.setTitle("Car manager");
        stage.setScene(new Scene(root));

        stage.show();
        RefreshHelper.getInstance().getController().refresh();
    }

    public static void run (String[] args) {
        launch();
    }
}