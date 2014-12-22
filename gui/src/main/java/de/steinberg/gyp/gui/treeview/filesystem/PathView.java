package de.steinberg.gyp.gui.treeview.filesystem;

import javafx.beans.InvalidationListener;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeCell;
import lombok.Data;

import java.nio.file.Path;

/**
 * Created by LKLeen on 22.12.2014.
 */
@Data
public class PathView {
    final Path path;
    FloatProperty correlation = new SimpleFloatProperty(0F);
    ChangeListener<? super Number> changeListener;
    PathTreeCell cell;

    public void updateChangeListener(PathTreeCell cell) {
        removeOldListener();
        addNewListener(cell);
    }

    private void addNewListener(final PathTreeCell cell) {
        changeListener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                cell.updateBackground(newValue.floatValue());
            }
        };
        correlation.addListener(changeListener);
    }

    private void removeOldListener() {
        if (changeListener != null) {
            correlation.removeListener(changeListener);
        }
    }

}
