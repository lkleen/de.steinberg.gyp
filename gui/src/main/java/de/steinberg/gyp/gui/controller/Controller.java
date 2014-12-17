package de.steinberg.gyp.gui.controller;

import de.steinberg.gyp.gui.icons.IconResolver;
import de.steinberg.gyp.gui.icons.IconView;
import de.steinberg.gyp.gui.treeview.filesystem.RootNodeCreator;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

/**
 * Created by LKLeen on 16.12.2014.
 */
@Slf4j
public class Controller {

    @Inject
    RootNodeCreator rootNodeCreator;

    @FXML
    TreeView<Path> filesystemTreeView;

    public Controller() {
        log.debug("hellou");
    }

    public void postConstruct() throws Exception {
        TreeItem<Path> root = rootNodeCreator.createRootNodes();
        root.setExpanded(true);
        filesystemTreeView.setRoot(root);
    }

    @FXML
    public void addNode() {
    }

}
