package de.steinberg.gyp.gui.view.tree.filesystem;

import de.steinberg.gyp.gui.view.tree.layout.TreeCellLayoutHandler;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import lombok.Data;

import java.nio.file.Path;

/**
 * Created by LKLeen on 22.12.2014.
 */
@Data
public class PathView {
    final Path path;
    final TreeCellLayoutHandler layoutHandler;

    FloatProperty correlation = new SimpleFloatProperty(0F);
    ChangeListener<? super Number> changeListener;
    PathTreeCell cell;

    public PathView(Path path, TreeCellLayoutHandler layoutHandler) {
        this.path = path;
        this.layoutHandler = layoutHandler;
    }

    public void addChangeListener(PathTreeCell cell) {
        if (changeListener != null)
            return;

        changeListener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                layoutHandler.updateBackGround(cell, newValue.floatValue());
            }
        };
        correlation.addListener(changeListener);
    }

}
