package de.steinberg.gyp.gui.treeview.filesystem;

import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.gui.FXMLElementsAccessor;
import de.steinberg.gyp.gui.treeview.ContextMenuFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        Menu submenu = new Menu("compare to");
        addComparableItems (submenu, root);
        contextMenu.getItems().add(submenu);
        treeCell.setContextMenu(contextMenu);
    }

    private void addComparableItems(Menu submenu, TreeItem<GypNode> root) {
        for( TreeItem<GypNode> node : root.getChildren()) {
            MenuItem menuItem = new MenuItem(node.getValue().getValue());
            addActionHandler(menuItem);
            submenu.getItems().add(menuItem);
        }

    }

    private void addActionHandler(MenuItem menuItem) {
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                log.info(event.toString());
            }
        });
    }
}
