package de.steinberg.gyp.gui.treeview.filesystem;

import de.steinberg.gyp.gui.exception.FileSystemAccessException;
import de.steinberg.gyp.gui.icons.IconResolver;
import javafx.scene.Parent;
import javafx.scene.control.Skin;
import javafx.scene.control.TreeCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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

        updateText(item);
        updateGraphic(item);

        try {
            pathNodeHandler.appendChildren(getTreeItem(), 1);
        } catch (FileSystemAccessException e) {
            setGraphic(iconResolver.getBrokenIcon());
            log.debug("could not append children {}", e.getMessage());
        }

    }

    private void updateText(Path item) {
        setText(item.toString());
    }

    private void updateGraphic(Path item) {
        setGraphic(iconResolver.getIconFor(item));
    }


}
