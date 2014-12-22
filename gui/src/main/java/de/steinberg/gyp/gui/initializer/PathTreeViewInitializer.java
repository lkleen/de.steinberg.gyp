package de.steinberg.gyp.gui.initializer;

import de.steinberg.gyp.gui.treeview.filesystem.PathTreeCellFactory;
import de.steinberg.gyp.gui.treeview.filesystem.PathView;
import de.steinberg.gyp.gui.treeview.filesystem.RootNodeCreator;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import javax.inject.Inject;

/**
 * Created by LKLeen on 16.12.2014.
 */
public class PathTreeViewInitializer {

    @Inject
    RootNodeCreator rootNodeCreator;

    @Inject
    PathTreeCellFactory pathTreeCellFactory;

    public void initialize (TreeView<PathView> pathTreeView) {
        TreeItem<PathView> root = rootNodeCreator.createRootNodes();
        root.setExpanded(true);
        pathTreeView.setRoot(root);
        pathTreeView.setCellFactory(pathTreeCellFactory);
        pathTreeView.setShowRoot(false);
    }
}
