package de.steinberg.gyp.gui.treeview.gypfile;

import de.steinberg.gyp.core.model.GypNode;
import javafx.scene.control.TreeCell;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Slf4j
public class GypTreeCell extends TreeCell<GypNode> {

    final GypNodeHandler gypNodeHandler;

    public GypTreeCell(GypNodeHandler gypNodeHandler) {
        this.gypNodeHandler = gypNodeHandler;
    }

    @Override
    protected void updateItem(GypNode item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setGraphic(null);
            return;
        }

        setText(item.getValue());

        gypNodeHandler.appendChildren(getTreeItem());
    }
}
