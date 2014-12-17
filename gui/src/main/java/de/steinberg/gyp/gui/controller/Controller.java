package de.steinberg.gyp.gui.controller;

import de.steinberg.gyp.core.model.GypFileTreeNode;
import de.steinberg.gyp.gui.initializer.GypTreeViewInitializer;
import de.steinberg.gyp.gui.initializer.PathTreeViewInitializer;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;
import javafx.stage.Window;
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

    @Inject
    GypTreeViewInitializer gypTreeViewInitializer;

    @FXML
    TreeView<GypFileTreeNode> gypTreeView;

    @FXML
    Window window;

    public void postConstruct() throws Exception {
        pathTreeViewInitializer.initialize(pathTreeView);
    }

    @FXML
    public void openFileChooser() {
        gypTreeViewInitializer.initialize(gypTreeView);
    }

}
