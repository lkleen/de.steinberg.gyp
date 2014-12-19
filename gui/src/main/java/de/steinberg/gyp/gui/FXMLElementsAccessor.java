package de.steinberg.gyp.gui;

import de.steinberg.gyp.core.model.GypNode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import lombok.Data;

import java.nio.file.Path;

/**
 * Created by LKLeen on 19.12.2014.
 */
@Data
public class FXMLElementsAccessor {
    TreeView<GypNode> gypTreeView;
    TreeView<Path> pathTreeView;
    TextArea logOutput;
}
