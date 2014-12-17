package de.steinberg.gyp.gui.controller;

import de.steinberg.gyp.gui.treeview.filesystem.RootNodeCreator;
import de.steinberg.gyp.gui.treeview.filesystem.PathTreeCellFactory;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
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
    PathTreeCellFactory pathTreeCellFactory;

    @Inject
    RootNodeCreator rootNodeCreator;

    @FXML
    TreeView<Path> filesystemTreeView;

    class Foo implements EventHandler {

        @Override
        public void handle(Event event) {
            log.info(event.toString());
        }
    }

    public Controller() {
        log.debug("hellou");
    }

    public void postConstruct() throws Exception {
        TreeItem<Path> root = rootNodeCreator.createRootNodes();
        root.setExpanded(true);
        filesystemTreeView.setRoot(root);
        filesystemTreeView.setCellFactory(pathTreeCellFactory);
    }

    @FXML
    public void checkEdit() {
        log.error("miuashdsajkdh");
    }

    @FXML
    public void addNode() {
        log.error("miuashdsajkdh");
    }

}
