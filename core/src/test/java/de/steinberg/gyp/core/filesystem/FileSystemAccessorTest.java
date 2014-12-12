package de.steinberg.gyp.core.filesystem;

import de.steinberg.gyp.core.TestBase;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static org.testng.Assert.*;

/**
 * Created by LKLeen on 12.12.2014.
 */
@Slf4j
public class FileSystemAccessorTest extends TestBase {

    @Inject
    FileSystemAccessor fileSystemAccessor;

    @Test
    public void test() {
        Path path = FileSystems.getDefault().getPath(".");
        FileSet files = fileSystemAccessor.getFilesFrom(path);

        files.forEach(file -> {
            logger.debug(file);
        });

        assertNotNull(files);

    }

}
