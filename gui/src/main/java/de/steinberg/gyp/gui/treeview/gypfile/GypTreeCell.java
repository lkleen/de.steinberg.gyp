package de.steinberg.gyp.gui.treeview.gypfile;

import de.steinberg.gyp.core.model.GypFileTreeNode;
import javafx.scene.control.TreeCell;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Slf4j
public class GypTreeCell extends TreeCell<GypFileTreeNode> {
    @Override
    protected void updateItem(GypFileTreeNode item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setGraphic(null);
            return;
        }

        //log.info(item.toString());
        //super.updateItem(item, empty);
    }
}
