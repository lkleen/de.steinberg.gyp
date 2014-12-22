package de.steinberg.gyp.gui.treeview.filesystem;

import de.steinberg.gyp.gui.icons.IconResolver;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Background;
import javafx.util.Callback;

import javax.inject.Inject;
import java.nio.file.Path;

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
