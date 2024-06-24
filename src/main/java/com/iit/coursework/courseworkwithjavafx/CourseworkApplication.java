package com.iit.coursework.courseworkwithjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class CourseworkApplication extends Application {
    static CourseworkController courseworkController;

    // A static method to set the CourseworkController instance.
    public static void setCourseworkController(CourseworkController controller) {
        courseworkController = controller;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CourseworkApplication.class.getResource("coursework-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 840, 550);
        stage.setTitle("Foodies Fave Food Center");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}