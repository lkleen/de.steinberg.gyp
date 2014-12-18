package de.steinberg.gyp.core.interpreter;

import de.steinberg.gyp.core.model.GypFile;
import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.core.model.GypNodeType;

import javax.inject.Inject;
import java.nio.file.FileSystem;
import java.util.ArrayList;
import java.util.List;

import static de.steinberg.gyp.core.model.GypNodeType.*;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class GypFileTreeParser {

    @Inject
    FileSystem fileSystem;

    public void parseTree(String root, GypNode parent, String key, GypFile gypFile) {
        List<GypNode> children = new ArrayList<>();

        for (String file : gypFile.getVariables().get(key)) {
            if (file == null)
                continue;

            GypNodeType type = getType(file);

            switch (type) {
                case CurrentPath:
                    children.add(newNode (file, type));
                    break;
                case RootPath:
                    children.add(newNode(parseRoot(root, file), type));
                    break;
                case Include:
                    GypNode child = newNode (file, type);
                    children.add(child);
                    parseTree(root, child, parseKey(file), gypFile);
                    break;
            }
        }

        parent.getChildren().addAll(children);
    }

    private GypNode newNode(String file, GypNodeType type) {
        return new GypNode(file, type);
    }

    private String parseKey(String file) {
        return file.replace("<@(","").replace(")","");
    }

    private String parseRoot(String root, String file) {
        return root + file.replace("<(ROOT)","");
    }

    private GypNodeType getType(String file) {
        if (file.startsWith("<@")) {
            return Include;
        } else if (file.startsWith("<(ROOT)")) {
            return RootPath;
        } else {
            return CurrentPath;
        }
    }

}
