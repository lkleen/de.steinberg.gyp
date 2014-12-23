package de.steinberg.gyp.gui.view.tree.gypfile;

import de.steinberg.gyp.core.model.GypNode;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LKLeen on 17.12.2014.
 */
public class GypNodeHandler {

    public void appendChildren(TreeItem<GypNode> node) {
        if (node.getChildren().size() > 0)
            return;;

        appendChildrenRecursive (node);
    }

    private void appendChildrenRecursive(TreeItem<GypNode> node) {
        GypNode gypNode = node.getValue();

        if (gypNode.getChildren().size() == 0)
            return;

        List<TreeItem<GypNode>> children = new ArrayList<>();


        for (GypNode treeNode : gypNode.getChildren()) {
            TreeItem<GypNode> child = new TreeItem<>(treeNode);
            children.add(child);
            appendChildrenRecursive(child);
        }

        node.getChildren().addAll(children);
    }

}
