package com.example.tnpslab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 780, 920);

        ServiceInjector serviceInjector = new ServiceInjectorImpl();
        serviceInjector.setServices(fxmlLoader.getController());

        stage.setTitle("MPZIP-11 :: TNPS Lab :: Scheme 12");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}