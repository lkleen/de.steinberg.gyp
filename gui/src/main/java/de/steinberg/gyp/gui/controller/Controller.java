package de.steinberg.gyp.gui.controller;

import de.steinberg.gyp.gui.initializer.PathTreeViewInitializer;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.nio.file.Path;

/**
 * Created by LKLeen on 16.12.2014.
 */
@Slf4j
public class Controller {

    @Inject
    PathTreeViewInitializer pathTreeViewInitializer;

    @FXML
    TreeView<Path> pathTreeView;

    public void postConstruct() throws Exception {
        pathTreeViewInitializer.initialize(pathTreeView);
    }

    @FXML
    public void openFileChooser() {}

}
