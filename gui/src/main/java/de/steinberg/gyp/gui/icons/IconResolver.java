package de.steinberg.gyp.gui.icons;

import de.steinberg.gyp.gui.exception.FileSystemAccessException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by LKLeen on 16.12.2014.
 */
public class IconResolver {

    public IconView getIconFor(Path path) {
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            if (!attr.isDirectory()) {
                return new FileIconView();
            } else {
                return new FolderIconView();
            }
        } catch (IOException e) {
            throw new FileSystemAccessException(e);
        }
    }

}
