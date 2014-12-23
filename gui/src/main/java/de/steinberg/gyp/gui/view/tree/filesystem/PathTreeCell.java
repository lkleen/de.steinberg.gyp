package de.steinberg.gyp.gui.view.tree.filesystem;

import de.steinberg.gyp.gui.exception.FileSystemAccessException;
import de.steinberg.gyp.gui.icons.IconResolver;
import javafx.beans.property.FloatProperty;
import javafx.scene.control.TreeCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Slf4j
public class PathTreeCell extends TreeCell<PathView> {

    final IconResolver iconResolver;
    final PathNodeHandler pathNodeHandler;
    final PathTreeCellContextMenuFactory contextMenuFactory;

    Background defaultBackGround;

    public PathTreeCell(IconResolver iconResolver, PathNodeHandler pathNodeHandler, PathTreeCellContextMenuFactory contextMenuFactory, FloatProperty other) {
        this.iconResolver = iconResolver;
        this.pathNodeHandler = pathNodeHandler;
        this.contextMenuFactory = contextMenuFactory;
    }

    @Override
    protected void updateItem(PathView item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setGraphic(null);
            return;
        }

        //setBackground(null);
        item.addChangeListener(this);

        updateText(item);
        updateGraphic(item);

        try {
            pathNodeHandler.appendChildren(getTreeItem(), 1);
        } catch (FileSystemAccessException e) {
            setGraphic(iconResolver.getBrokenIcon());
            log.debug("could not append children {}", e.getMessage());
        }

        contextMenuFactory.createContextMenu(this);
    }



    public void updateBackground(float correlationValue) {
        if(correlationValue >= 1)
            setBackground(red());
        else
            setBackground(green());
    }

    private Background red() {
        return new Background(new BackgroundFill(Color.rgb(100, 0, 0), null, null));
    }

    private Background green() {
        return new Background(new BackgroundFill(Color.rgb(0, 100, 0), null, null));
    }

    private Background white() {
        return new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null));
    }

    private void updateText(PathView item) {
        setText(item.getPath().toString());
    }

    private void updateGraphic(PathView item) {
        setGraphic(iconResolver.getIconFor(item.getPath()));
    }


}
