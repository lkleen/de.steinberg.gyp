package de.steinberg.gyp.core.interpreter;

import de.steinberg.gyp.core.model.GypFile;
import de.steinberg.gyp.core.model.GypFileTree;
import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.core.model.GypNodeType;

import javax.inject.Inject;

/**
 * Created by LKLeen on 12.12.2014.
 */
public class GypFileInterpreter {

    @Inject
    GypFileTreeParser gypFileTreeParser;

    public GypFileTree getFilesListFrom (String base, GypFile gypFile) {

        GypFileTree tree = new GypFileTree();
        GypNode root = new GypNode(base, GypNodeType.Root);
        tree.setRoot(root);

        for (String key : gypFile.getVariables().keySet()) {
            GypNode child = new GypNode(key, findNodeType(key));
            root.getChildren().add(child);
            gypFileTreeParser.parseTree(base, child, key, gypFile);
        }

        return tree;
    }

    private GypNodeType findNodeType(String key) {
        if (key.contains("sources")) {
            return GypNodeType.SourceFiles;
        } else {
            return GypNodeType.Unknown;
        }
    }

}
