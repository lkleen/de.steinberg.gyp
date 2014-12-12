package de.steinberg.gyp.core.interpreter;

import de.steinberg.gyp.core.model.GypFile;
import de.steinberg.gyp.core.model.GypFileTreeNode;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class GypFileTreeParser {

    enum EntryType {
        CurrentPath,
        RootPath,
        Include,
    }

    public void parseTree(String root, GypFile gypFile, String key, GypFileTreeNode parent) {
        GypFileTreeNode node = new GypFileTreeNode();
        parent.getChildren().add(node);

        for (String file : gypFile.getVariables().get(key)) {
            if (file == null)
                continue;

            switch (getType(file)) {
                case CurrentPath:
                    node.getFileSet().add(file);
                    break;
                case RootPath:
                    node.getFileSet().add(parseRoot(root, file));
                    break;
                case Include:
                    parseTree(root, gypFile, parseKey(file), node);
                    break;
            }

        }
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
