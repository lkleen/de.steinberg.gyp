package de.steinberg.gyp.core.filesystem;

import de.steinberg.gyp.core.exception.FileSystemException;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.stream.Stream;

/**
 * Created by LKLeen on 12.12.2014.
 */
@Slf4j
public class FileSystemAccessor {

    @Inject
    FileSystem fileSystem;

    String pathPattern = "glob:*.h";

    public FileSet getFilesFrom(Path start) {
        FileSet files = new FileSet();
        PathMatcher matcher = fileSystem.getPathMatcher(pathPattern);

        try (Stream<Path> stream = Files.walk(start)) {

            stream
                    .parallel()
                    .filter(path -> path.toFile().isFile())
                    .filter(path -> matcher.matches(path.getFileName()))
                    .forEach(path -> {
                        files.add(path.toString());
                    });

            return files;
        } catch (IOException e) {
            throw new FileSystemException(e);
        }

    }

}
