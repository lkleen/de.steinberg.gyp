package de.steinberg.gyp.gui.treeview;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.TreeCell;

/**
 * Created by LKLeen on 19.12.2014.
 */
public interface ContextMenuFactory<T extends TreeCell> {

    void createContextMenu(T treeCell);

}
