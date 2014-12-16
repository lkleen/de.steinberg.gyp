package de.steinberg.gyp.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by LKLeen on 16.12.2014.
 */
public class MainApplication extends Application {

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("gypComparator");
        createSceneWith(stage);
        stage.show();
    }

    private Scene createSceneWith(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClassLoader.getSystemResource("main.fxml"));
        GridPane pane = (GridPane) loader.load();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        return scene;
    }
}
