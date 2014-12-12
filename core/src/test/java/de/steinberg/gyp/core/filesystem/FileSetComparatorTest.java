package de.steinberg.gyp.core.filesystem;

import de.steinberg.gyp.core.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class FileSetComparatorTest extends TestBase {

    @Test
    public void test() {
        FileSet left = new FileSet();
        FileSet right = new FileSet();

        FileSetComparator comparator = new FileSetComparator();

        left.add("file01");
        left.add("file02");
        left.add("file03");
        left.add("file04");

        right.add("file03");
        right.add("file04");
        right.add("file05");
        right.add("file06");

        FileSetComparisonResult result = comparator.compare(left, right);

        FileSet expectedMissingLeft = new FileSet();
        FileSet expectedMissingRight = new FileSet();

        expectedMissingLeft.add("file05");
        expectedMissingLeft.add("file06");

        expectedMissingRight.add("file01");
        expectedMissingRight.add("file02");

        assertEquals(expectedMissingLeft, result.missingLeft);
        assertEquals(expectedMissingRight, result.missingRight);

    }

}
