package de.steinberg.gyp.gui.treeview.filesystem;

import de.steinberg.gyp.gui.icons.IconResolver;
import javafx.scene.Parent;
import javafx.scene.control.Skin;
import javafx.scene.control.TreeCell;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Slf4j
public class PathTreeCell extends TreeCell<Path> {

    final IconResolver iconResolver;
    final PathNodeHandler pathNodeHandler;

    public PathTreeCell(IconResolver iconResolver, PathNodeHandler pathNodeHandler) {
        this.iconResolver = iconResolver;
        this.pathNodeHandler = pathNodeHandler;
    }

    @Override
    protected void updateItem(Path item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setGraphic(null);
            return;
        }
        setText(item.toString());
        setGraphic(iconResolver.getIconFor(item));

        pathNodeHandler.appendChildren(getTreeItem(), 1);
    }


}
