package de.steinberg.gyp.gui.view.tree.filesystem;

import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.gui.FXMLElementsAccessor;
import de.steinberg.gyp.gui.view.tree.ContextMenuFactory;
import javafx.scene.control.*;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.nio.file.Path;

/**
 * Created by LKLeen on 19.12.2014.
 */
@Slf4j
public abstract class PathTreeCellContextMenuFactory implements ContextMenuFactory {

    @Inject
    FXMLElementsAccessor fxmlElementsAccessor;

    protected abstract PathTreeViewComparator createComparator();

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
            addActionHandler(menuItem, gypNode.getValue(), pathNode.getValue().getPath());
            menu.getItems().add(menuItem);
        }
        return menu;
    }

    private void addActionHandler(MenuItem menuItem, GypNode gypNode, Path path) {
        PathTreeViewComparator comparator = createComparator();
        comparator.setParameters(new PathComparisonParameters(gypNode, path));
        PathComparisonEventHandler eventHandler = new PathComparisonEventHandler(comparator);
        menuItem.setOnAction(eventHandler);
    }
}
