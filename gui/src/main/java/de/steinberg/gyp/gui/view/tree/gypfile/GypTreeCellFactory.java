package de.steinberg.gyp.gui.view.tree.gypfile;

import de.steinberg.gyp.core.model.GypNode;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

import javax.inject.Inject;

/**
 * Created by LKLeen on 17.12.2014.
 */
public class GypTreeCellFactory implements Callback<TreeView<GypNode>, TreeCell<GypNode>> {

    @Inject
    GypNodeHandler gypNodeHandler;

    @Override
    public TreeCell<GypNode> call(TreeView<GypNode> param) {
        return new GypTreeCell(gypNodeHandler);
    }
}
