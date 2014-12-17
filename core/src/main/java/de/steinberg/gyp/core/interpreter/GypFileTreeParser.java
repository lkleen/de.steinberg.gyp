package de.steinberg.gyp.core.interpreter;

import de.steinberg.gyp.core.model.GypFile;
import de.steinberg.gyp.core.model.GypFileTreeNode;

import javax.inject.Inject;
import java.nio.file.FileSystem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class GypFileTreeParser {

    @Inject
    FileSystem fileSystem;

    enum EntryType {
        CurrentPath,
        RootPath,
        Include,
    }

    public void parseTree(String root, GypFileTreeNode parent, String key, GypFile gypFile) {
        List<GypFileTreeNode> children = new ArrayList<>();

        for (String file : gypFile.getVariables().get(key)) {
            if (file == null)
                continue;

            switch (getType(file)) {
                case CurrentPath:
                    children.add(newNode (file));
                    break;
                case RootPath:
                    children.add(newNode(parseRoot(root, file)));
                    break;
                case Include:
                    GypFileTreeNode child = newNode (file);
                    children.add(child);
                    parseTree(root, child, parseKey(file), gypFile);
                    break;
            }
        }

        parent.getChildren().addAll(children);
    }

    private GypFileTreeNode newNode(String file) {
        return new GypFileTreeNode(file);
    }

    private String parseKey(String file) {
        return file.replace("<@(","").replace(")","");
    }

    private String parseRoot(String root, String file) {
        return root + file.replace("<(ROOT)","");
    }

    private EntryType getType(String file) {
        if (file.startsWith("<@")) {
            return EntryType.Include;
        } else if (file.startsWith("<(ROOT)")) {
            return EntryType.RootPath;
        } else {
            return EntryType.CurrentPath;
        }
    }

}
