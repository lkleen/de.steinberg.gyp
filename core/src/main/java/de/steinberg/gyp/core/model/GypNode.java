package de.steinberg.gyp.core.model;

import de.steinberg.gyp.core.filesystem.FileSet;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static de.steinberg.gyp.core.model.GypNodeType.*;

/**
 * Created by LKLeen on 12.12.2014.
 */
@Data
public class GypNode {

    final List<GypNode> children = new ArrayList<>();
    final String value;
    final GypNodeType type;

    /**
     * @return all files of this node and its children
     */
    public FileSet getAllFiles() {
        FileSet result = new FileSet();
        getAllFiles(result, this, children);
        return result;
    }

    private void getAllFiles(FileSet result, GypNode node, List<GypNode> children) {
        if (node.getType() == CurrentPath || node.getType() == RootPath) {
            result.add(node.getValue());
        } else {
            for (GypNode child : children) {
                getAllFiles(result, child, child.children);
            }
        }
    }


}
