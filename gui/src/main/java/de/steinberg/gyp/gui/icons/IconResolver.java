package de.steinberg.gyp.gui.icons;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by LKLeen on 16.12.2014.
 */
public class IconResolver {

    public IconView getIconFor (Path path) {
        if (path.toFile().isFile()) {
            return new FileIconView();
        } else {
            return new FolderIconView();
        }

    }

}
