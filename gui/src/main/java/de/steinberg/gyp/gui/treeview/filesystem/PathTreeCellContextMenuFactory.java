package de.steinberg.gyp.gui.treeview.filesystem;

import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.gui.FXMLElementsAccessor;
import de.steinberg.gyp.gui.treeview.ContextMenuFactory;
import javafx.scene.control.*;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

/**
 * Created by LKLeen on 19.12.2014.
 */
@Slf4j
public class PathTreeCellContextMenuFactory implements ContextMenuFactory {

    @Inject
    FXMLElementsAccessor fxmlElementsAccessor;

    @Override
    public void createContextMenu(TreeCell treeCell) {
        TreeView<GypNode> gypTreeView = fxmlElementsAccessor.getGypTreeView();
        TreeItem<GypNode> root = gypTreeView.getRoot();

        if(root == null)
            return;

        ContextMenu contextMenu = new ContextMenu();
        Menu submenu = createSubmenu(root, treeCell.getTreeItem());
        contextMenu.getItems().add(submenu);
        treeCell.setContextMenu(contextMenu);
    }

    private Menu createSubmenu(TreeItem<GypNode> root, TreeItem<PathView> pathNode) {
        Menu menu = new Menu("compare");

        for( TreeItem<GypNode> gypNode : root.getChildren()) {
            MenuItem menuItem = new MenuItem(gypNode.getValue().getValue());
            addActionHandler(menuItem, gypNode.getValue(), pathNode.getValue());
            menu.getItems().add(menuItem);
        }
        return menu;
    }

    private void addActionHandler(MenuItem menuItem, GypNode gypNode, PathView pathView) {
        menuItem.setOnAction(new PathViewComparisonEventHandler(gypNode, pathView));
    }
}
