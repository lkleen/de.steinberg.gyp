package de.steinberg.gyp.gui;

import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.gui.treeview.filesystem.PathView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import lombok.Data;

/**
 * Created by LKLeen on 19.12.2014.
 */
@Data
public class FXMLElementsAccessor {
    TreeView<GypNode> gypTreeView;
    TreeView<PathView> pathTreeView;
    TextArea logOutput;
}
