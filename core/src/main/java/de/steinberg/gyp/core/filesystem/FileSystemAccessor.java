package de.steinberg.gyp.core.filesystem;

import de.steinberg.gyp.core.exception.FileSystemException;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class FileSystemAccessor {

    public FileSet getFilesFrom(Path start) {
        FileSet files = new FileSet();

        try (Stream<Path> stream = Files.walk(start)) {

            stream
                    .parallel()
                    .filter(path -> path.toFile().isFile())
                    .forEach(path -> {
                        files.add(path.toString());
                    });

            return files;
        } catch (IOException e) {
            throw new FileSystemException(e);
        }

    }

}
