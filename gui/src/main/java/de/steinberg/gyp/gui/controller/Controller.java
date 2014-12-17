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

        File rootFile = new File("/");

        FileSystem fs = FileSystems.getDefault();

        Path rootPath = fs.getPath("/");

        BasicFileAttributes attr = Files.readAttributes(rootPath, BasicFileAttributes.class);

        attr.isDirectory();

        fs.provider().readAttributes(rootPath, BasicFileAttributes.class);

        FileSystems.getDefault().supportedFileAttributeViews().forEach(stuff -> {
            log.info(stuff);
        });


        IconResolver iconResolver = new IconResolver();

        TreeItem<Path> root = new TreeItem<>(rootPath);
        filesystemTreeView.setRoot(root);

        try (Stream<Path> stream = Files.walk(rootPath, 1)) {
            stream.forEach(path -> {
                    TreeItem<Path> child = new TreeItem<>(path, iconResolver.getIconFor(path));
                    root.getChildren().add(child);
            });
        } catch (IOException e) {
            Controller.log.error(e.getMessage());
        }

        root.setExpanded(true);
    }

    @FXML
    public void addNode() {
    }

}
