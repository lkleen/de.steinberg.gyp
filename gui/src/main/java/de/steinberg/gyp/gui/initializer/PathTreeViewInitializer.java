package de.steinberg.gyp.gui.initializer;

import de.steinberg.gyp.gui.treeview.filesystem.PathTreeCellFactory;
import de.steinberg.gyp.gui.treeview.filesystem.RootNodeCreator;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import javax.inject.Inject;
import java.nio.file.Path;

/**
 * Created by LKLeen on 16.12.2014.
 */
public class PathTreeViewInitializer {

    @Inject
    RootNodeCreator rootNodeCreator;

    @Inject
    PathTreeCellFactory pathTreeCellFactory;

    public void initialize (TreeView<Path> pathTreeView) {
        TreeItem<Path> root = rootNodeCreator.createRootNodes();
        root.setExpanded(true);
        pathTreeView.setRoot(root);
        pathTreeView.setCellFactory(pathTreeCellFactory);
        pathTreeView.setShowRoot(false);
    }
}
