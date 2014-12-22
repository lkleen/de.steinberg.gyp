package de.steinberg.gyp.gui.treeview.filesystem;

import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.core.model.GypNodeType;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

import static de.steinberg.gyp.core.model.GypNodeType.*;

/**
 * Created by LKLeen on 19.12.2014.
 */
public class PathTreeViewComparator implements Callable<Void> {

    final TreeCell<GypNode> gypNodeTreeCell;
    final TreeCell<Path> pathTreeCell;

    public PathTreeViewComparator(TreeCell<GypNode> gypNodeTreeCell, TreeCell<Path> pathTreeCell) {
        this.gypNodeTreeCell = gypNodeTreeCell;
        this.pathTreeCell = pathTreeCell;
    }

    @Override
    public Void call() throws Exception {
        compareGypToPath(gypNodeTreeCell, pathTreeCell);
        return null;
    }

    private void compareGypToPath(TreeCell<GypNode> gypNodeTreeCell, TreeCell<Path> pathTreeCell) {
        /*
        boolean exists = compare(gypNodeTreeCell, pathTreeCell);

        pathTreeCell.

        if (exists) {
            // mark green
            return;
        }


        for (TreeItem<Path> child : pathTreeCell.getTreeItem().getChildren()) {
            compareGypToPath(gypNodeTreeCell, child);
        }

        // mark red
        */
    }

    private boolean compare(TreeItem<GypNode> gypNodeTreeItem, TreeItem<Path> pathTreeItem) {
        GypNode gypNode = gypNodeTreeItem.getValue();
        GypNodeType type = gypNode.getType();

        if (type == CurrentPath || type == RootPath) {
            Path path = Paths.get(gypNode.getValue());
            return path.equals(pathTreeItem.getValue());
        } else {
            return false;
        }
    }
}
