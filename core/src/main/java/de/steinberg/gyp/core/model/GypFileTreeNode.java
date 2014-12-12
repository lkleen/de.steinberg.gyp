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

}
