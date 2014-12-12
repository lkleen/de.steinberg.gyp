package de.steinberg.gyp.core.filesystem;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class FileSetComparator {

    public FileSetComparisonResult compare(FileSet left, FileSet right) {
        FileSetComparisonResult result = new FileSetComparisonResult();

        left.forEach(file -> {
            if (!right.contains(file)) {result.missingRight.add(file);}
        });

        right.forEach(file-> {
            if (!left.contains(file)) {result.missingLeft.add(file);}
        });

        return result;
    }

}
