package de.steinberg.gyp.gui.view.tree.filesystem;

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

    PathTreeCell cell;

    public PathView(Path path) {
        this.path = path;
    }


}
