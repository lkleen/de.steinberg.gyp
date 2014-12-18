package de.steinberg.gyp.gui.icons;

import de.steinberg.gyp.core.exception.FileSystemException;
import de.steinberg.gyp.gui.exception.FileSystemAccessException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by LKLeen on 16.12.2014.
 */
@Slf4j
public class IconResolver {

    public IconView getIconFor(Path path) {
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            if (!attr.isDirectory()) {
                return new FileIconView();
            } else {
                return new FolderIconView();
            }
        } catch (FileSystemException | IOException e) {
            log.debug(e.getMessage());
            return new BrokenIconView();
        }
    }

    public IconView getBrokenIcon () {
        return new BrokenIconView();
    }

}
