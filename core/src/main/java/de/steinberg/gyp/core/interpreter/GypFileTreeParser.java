package de.steinberg.gyp.core.interpreter;

import de.steinberg.gyp.core.model.GypFile;
import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.core.model.GypNodeType;

import javax.inject.Inject;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static de.steinberg.gyp.core.model.GypNodeType.*;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class GypFileTreeParser {

    public void parseTree(Path gypFilePath, String root, GypNode parent, String key, GypFile gypFile) {
        List<GypNode> children = new ArrayList<>();

        Path parentDir = gypFilePath.getParent();

        Path baseDir = (parentDir != null) ? parentDir.normalize() : Paths.get(".");
        Path rootDir = Paths.get(baseDir.toString(), root).normalize();

        for (String entry : gypFile.getVariables().get(key)) {
            if (entry == null)
                continue;

            GypNodeType type = getType(entry);

            switch (type) {
                case CurrentPath:
                    Path path = Paths.get(baseDir.toString(), entry);
                    children.add(newNode(path.toString(),type));
                    break;
                case RootPath:
                    children.add(newNode(parseRoot(rootDir, entry), type));
                    break;
                case Include:
                    GypNode child = newNode (entry, type);
                    children.add(child);
                    parseTree(gypFilePath, root, child, parseKey(entry), gypFile);
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

    private String parseRoot(Path root, String file) {
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
