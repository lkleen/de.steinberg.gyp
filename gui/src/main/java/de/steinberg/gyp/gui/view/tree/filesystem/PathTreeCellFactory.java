package de.steinberg.gyp.gui.view.tree.filesystem;

import de.steinberg.gyp.gui.icons.IconResolver;
import javafx.beans.property.FloatProperty;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

import javax.inject.Inject;

/**
 * Created by LKLeen on 17.12.2014.
 */
public class PathTreeCellFactory implements Callback<TreeView<PathView>, TreeCell<PathView>> {

    @Inject
    IconResolver iconResolver;

    @Inject
    PathNodeHandler pathNodeHandler;

    @Inject
    PathTreeCellContextMenuFactory contextMenuFactory;

    @Inject
    FloatProperty floatProperty;

    @Override
    public TreeCell<PathView> call(TreeView<PathView> param) {
        return new PathTreeCell(iconResolver, pathNodeHandler, contextMenuFactory, floatProperty);
    }
}
