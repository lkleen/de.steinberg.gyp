package de.steinberg.gyp.gui.treeview.gypfile;

import de.steinberg.gyp.core.model.GypFileTreeNode;
import javafx.scene.control.TreeItem;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LKLeen on 17.12.2014.
 */
public class GypNodeHandler {

    public void appendChildren(TreeItem<GypFileTreeNode> node) {
        if (node.getChildren().size() > 0)
            return;;

        appendChildrenRecursive (node);
    }

    private void appendChildrenRecursive(TreeItem<GypFileTreeNode> node) {
        if (node.getChildren().size() == 0)
            return;

        List<TreeItem<GypFileTreeNode>> children = new ArrayList<>();

        GypFileTreeNode gypFileTreeNode = node.getValue();

        for (GypFileTreeNode treeNode : gypFileTreeNode.getChildren()) {
            TreeItem<GypFileTreeNode> child = new TreeItem<>(treeNode);
            children.add(child);
            appendChildrenRecursive(child);
        }

        node.getChildren().addAll(children);
    }

}
