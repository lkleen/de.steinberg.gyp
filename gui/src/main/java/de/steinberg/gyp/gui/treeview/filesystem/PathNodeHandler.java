package de.steinberg.gyp.gui.treeview.filesystem;

import de.steinberg.gyp.gui.exception.FileSystemAccessException;
import de.steinberg.gyp.gui.icons.IconResolver;
import javafx.scene.control.TreeItem;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Slf4j
public class PathNodeHandler {

    @Inject
    IconResolver iconResolver;

    public void appendChildren(TreeItem<Path> node, int maxDepth) {
        if (node.getChildren().size() > 0)
            return;;

        appendChildrenRecursive (node, maxDepth);
    }

    private void appendChildrenRecursive(TreeItem<Path> node, int maxDepth) {
        if (maxDepth == 0)
            return;

        List<TreeItem<Path>> children = new ArrayList<>();

        try (Stream<Path> stream = Files.walk(node.getValue(), 1)) {
                stream.forEach(path -> {
                    TreeItem<Path> child = new TreeItem<Path>(path, iconResolver.getIconFor(path));
                    children.add(child);
                    appendChildrenRecursive(child, maxDepth - 1);
                });
        } catch (FileSystemException e) {
            PathNodeHandler.log.error(e.getMessage());
        } catch (IOException e) {
            throw new FileSystemAccessException(e);
        }

        node.getChildren().addAll(children);

    }

}
