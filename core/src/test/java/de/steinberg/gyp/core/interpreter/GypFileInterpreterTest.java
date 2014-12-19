package de.steinberg.gyp.core.interpreter;

import de.steinberg.gyp.core.TestBase;
import de.steinberg.gyp.core.filesystem.FileSet;
import de.steinberg.gyp.core.json.GypFileParser;
import de.steinberg.gyp.core.model.GypFile;
import de.steinberg.gyp.core.model.GypFileTree;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import javax.inject.Inject;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class GypFileInterpreterTest extends TestBase {

    @Inject
    GypFileInterpreter interpreter;

    @Inject
    GypFileParser parser;

    @Test
    public void test() {
        GypFile gypFile = parser.parse(ClassLoader.getSystemResourceAsStream("files.gypi"), GypFile.class);
        Path path = FileSystems.getDefault().getPath("files.gypi");
        String base = "some/folder";
        GypFileTree tree = interpreter.getFileTreeFrom(path, base, gypFile);
        assertNotNull(tree);

        FileSet fileSet = tree.getRoot().getAllFiles();
        assertEquals(10, fileSet.size());
    }

}
