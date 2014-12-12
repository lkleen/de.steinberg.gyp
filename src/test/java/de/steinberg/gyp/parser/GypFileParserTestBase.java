package de.steinberg.gyp.parser;

import de.steinberg.gyp.TestBase;
import de.steinberg.gyp.model.GypFile;
import de.steinberg.gyp.parser.json.GypFileParser;
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
