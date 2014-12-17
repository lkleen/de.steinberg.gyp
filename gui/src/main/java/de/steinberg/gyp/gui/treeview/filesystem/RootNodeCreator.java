package de.steinberg.gyp.gui.treeview.filesystem;

import de.steinberg.gyp.gui.icons.ComputerIconView;
import de.steinberg.gyp.gui.icons.FolderIconView;
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
        TreeItem<Path> root = new TreeItem<>(null, new ComputerIconView());
        for (Path path : fileSystem.getRootDirectories()) {
            TreeItem<Path> child = new TreeItem<>(path, new FolderIconView ());
            root.getChildren().add(child);
        }
        return root;
    }

}
