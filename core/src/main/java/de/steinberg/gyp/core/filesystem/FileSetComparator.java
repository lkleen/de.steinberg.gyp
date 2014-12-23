package de.steinberg.gyp.core.filesystem;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class FileSetComparator {

    public FileSetComparisonResult compare(FileSet left, FileSet right) {
        FileSetComparisonResult result = new FileSetComparisonResult();

        Set<Path> leftPaths = toPathSet(left);
        Set<Path> rightPaths = toPathSet(right);

        Set<Path> matching = new TreeSet<>();


        leftPaths.forEach(file -> {
            if (!rightPaths.contains(file)) {
                result.missingRight.add(file.toString());
            } else {
                matching.add(file);
            }
        });

        rightPaths.removeAll(matching);
        leftPaths.removeAll(matching);

        rightPaths.forEach(file-> {
            if (!leftPaths.contains(file)) {result.missingLeft.add(file.toString());}
        });

        return result;
    }

    private Set<Path> toPathSet(FileSet fileSet) {
        TreeSet<Path> pathSet = new TreeSet<>();
        for (String s : fileSet) {
            pathSet.add(Paths.get(s).normalize());
        }
        return pathSet;
    }
}
