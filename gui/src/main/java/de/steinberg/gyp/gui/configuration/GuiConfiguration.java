package de.steinberg.gyp.gui.configuration;

import de.steinberg.gyp.gui.controller.Controller;
import de.steinberg.gyp.gui.treeview.filesystem.RootNodeCreator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Configuration
public class GuiConfiguration {

    /*
    @Bean
    public Controller controller() {
        return new Controller();
    }
    */

    @Bean
    public FileSystem fileSystem () {
        return FileSystems.getDefault();
    }

    @Bean
    public RootNodeCreator rootNodeCreator () {
        return new RootNodeCreator();
    }

}
