package de.steinberg.gyp.core.interpreter;

import de.steinberg.gyp.core.filesystem.FileSet;
import de.steinberg.gyp.core.model.GypFile;
import de.steinberg.gyp.core.model.GypFileTree;
import de.steinberg.gyp.core.model.GypFileTreeNode;

import javax.inject.Inject;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.Map;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class GypFileInterpreter {

    @Inject
    GypFileTreeParser gypFileTreeParser;

    public GypFileTree getFilesListFrom (String base, GypFile gypFile) {

        GypFileTree tree = new GypFileTree();
        GypFileTreeNode root = new GypFileTreeNode(base);
        tree.setRoot(root);

        for (String key : gypFile.getVariables().keySet()) {
            GypFileTreeNode child = new GypFileTreeNode(key);
            root.getChildren().add(child);
            gypFileTreeParser.parseTree(base, child, key, gypFile);
        }

        return tree;
    }

}
