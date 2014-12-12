package de.steinberg.gyp.core.model;

import de.steinberg.gyp.core.filesystem.FileSet;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LKLeen on 12.12.2014.
 */
@Data
public class GypFileTreeNode {

    final List<GypFileTreeNode> children = new ArrayList<>();
    final FileSet fileSet = new FileSet();

    /**
     * @return all files of this node and its children
     */
    public FileSet getAllFiles() {
        FileSet result = new FileSet();
        getAllFiles(result, this, children);
        return result;
    }

    private void getAllFiles(FileSet result, GypFileTreeNode node, List<GypFileTreeNode> children) {
        result.addAll(node.getFileSet());
        for (GypFileTreeNode child : children) {
            getAllFiles(result, child, child.children);
        }
    }


}
