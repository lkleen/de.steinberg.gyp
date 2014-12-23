package de.steinberg.gyp.core.filesystem;

import java.util.TreeSet;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class FileSet extends TreeSet<String> {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        forEach(line -> {
            sb.append(line + "\n");
        });
        return sb.toString();
    }

}
