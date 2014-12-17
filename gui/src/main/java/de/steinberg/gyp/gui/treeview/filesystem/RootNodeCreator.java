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

    @Inject
    PathNodeHandler pathNodeHandler;

    public TreeItem<Path> createRootNodes() {
        TreeItem<Path> root = new TreeItem<>();
        for (Path path : fileSystem.getRootDirectories()) {
            TreeItem<Path> child = new TreeItem<>(path);
            root.getChildren().add(child);
            pathNodeHandler.appendChildren(child, 2);
        }
        return root;
    }

}
