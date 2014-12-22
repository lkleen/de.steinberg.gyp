package de.steinberg.gyp.gui.treeview.filesystem;

import de.steinberg.gyp.gui.exception.FileSystemAccessException;
import de.steinberg.gyp.gui.icons.IconResolver;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.FloatBinding;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
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
public class PathTreeCell extends TreeCell<PathView> {

    final IconResolver iconResolver;
    final PathNodeHandler pathNodeHandler;
    final PathTreeCellContextMenuFactory contextMenuFactory;

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
            setBackground(null);
            return;
        }

        //setBackground(null);
        item.updateChangeListener(this);

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
