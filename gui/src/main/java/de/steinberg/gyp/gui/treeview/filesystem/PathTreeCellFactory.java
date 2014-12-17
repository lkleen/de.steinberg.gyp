package de.steinberg.gyp.gui.treeview.filesystem;

import de.steinberg.gyp.gui.icons.IconResolver;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

import javax.inject.Inject;
import java.nio.file.Path;

/**
 * Created by LKLeen on 17.12.2014.
 */
public class PathTreeCellFactory implements Callback<TreeView<Path>, TreeCell<Path>> {

    @Inject
    IconResolver iconResolver;

    @Inject
    PathNodeHandler pathNodeHandler;

    @Override
    public TreeCell<Path> call(TreeView<Path> param) {
        return new PathTreeCell(iconResolver, pathNodeHandler);
    }
}
