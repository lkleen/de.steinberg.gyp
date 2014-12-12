package de.steinberg.gyp.core.parser;

import de.steinberg.gyp.core.TestBase;
import de.steinberg.gyp.core.json.GypFileParser;
import de.steinberg.gyp.core.model.GypFile;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.testng.Assert.assertNotNull;

/**
 * Created by LKLeen on 10.12.2014.
 */
public class GypFileParserTestBase extends TestBase {

    @Inject
    GypFileParser parser;

    @Test
    public void test() {
        GypFile gypFile = parser.parse(ClassLoader.getSystemResourceAsStream("files.gypi"), GypFile.class);
        assertNotNull(gypFile);
    }


}
