package de.steinberg.gyp.gui.view.tree.filesystem;

import de.steinberg.gyp.core.model.GypNode;
import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.nio.file.Path;

@Data
public class PathComparisonParameters {
    final GypNode gypNode;
    final Path path;

    public PathComparisonParameters(GypNode gypNode, Path path) {
        this.gypNode = gypNode;
        this.path = path;
    }
}
