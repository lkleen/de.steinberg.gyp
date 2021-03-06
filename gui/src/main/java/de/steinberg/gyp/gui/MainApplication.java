package de.steinberg.gyp.gui;

import de.steinberg.gyp.gui.configuration.GuiConfiguration;
import de.steinberg.gyp.gui.controller.Controller;
import de.steinberg.gyp.gui.logging.LogAppender;
import de.steinberg.gyp.gui.logging.LogWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;

/**
 * Created by LKLeen on 16.12.2014.
 */
public class MainApplication extends Application {

    @Inject
    Scene scene;

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
        GridPane pane = (GridPane) loader.load(ClassLoader.getSystemResourceAsStream("main.fxml"));

        ApplicationContext context = new AnnotationConfigApplicationContext(GuiConfiguration.class);
        initializeController(context, loader.getController());

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        return scene;
    }

    private void initializeController(ApplicationContext context, Controller controller) throws Exception {
        AutowireCapableBeanFactory bf = context.getAutowireCapableBeanFactory();
        bf.autowireBean(controller);
        controller.postConstruct();
    }
}
