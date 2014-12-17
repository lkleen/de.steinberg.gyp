package de.steinberg.gyp.gui.treeview.gypfile;

import de.steinberg.gyp.core.model.GypFileTreeNode;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

import javax.inject.Inject;

/**
 * Created by LKLeen on 17.12.2014.
 */
public class GypTreeCellFactory implements Callback<TreeView<GypFileTreeNode>, TreeCell<GypFileTreeNode>> {

    @Inject
    GypNodeHandler gypNodeHandler;

    @Override
    public TreeCell<GypFileTreeNode> call(TreeView<GypFileTreeNode> param) {
        return new GypTreeCell(gypNodeHandler);
    }
}
