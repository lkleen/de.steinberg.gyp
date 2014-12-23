package de.steinberg.gyp.gui.view.tree.filesystem;

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

    @Inject
    FileSystem fileSystem;


    public void appendChildren(TreeItem<PathView> node, int maxDepth) {
        if (node.getChildren().size() > 0)
            return;;

        appendChildrenRecursive (node, maxDepth);
    }

    private void appendChildrenRecursive(TreeItem<PathView> node, int maxDepth) {
        if (maxDepth == 0)
            return;

        List<TreeItem<PathView>> children = new ArrayList<>();

        try (Stream<Path> stream = Files.walk(node.getValue().getPath(), 1)) {
                stream
                        .filter(path -> {return !path.equals(node.getValue().getPath());} )
                        .forEach(path -> {
                    TreeItem<PathView> child = new TreeItem<>(new PathView(path), iconResolver.getIconFor(path));
                    children.add(child);
                    appendChildrenRecursive(child, maxDepth - 1);
                });
        } catch (FileSystemException e) {
            throw new FileSystemAccessException(e);
        } catch (IOException e) {
            throw new FileSystemAccessException(e);
        }

        node.getChildren().addAll(children);

    }

}
