package de.steinberg.gyp.gui.treeview.filesystem;

import javafx.scene.control.TreeItem;

import javax.inject.Inject;
import java.nio.file.FileSystem;
import java.nio.file.Path;

/**
 * Created by LKLeen on 17.12.2014.
 */
public class RootNodeCreator {

    @Inject
    FileSystem fileSystem;

    public TreeItem<Path> createRootNodes() {
        TreeItem<Path> root = new TreeItem<>();
        for (Path path : fileSystem.getRootDirectories()) {
            root.getChildren().add(new TreeItem<>(path));
        }
        return root;
    }

}
