package de.steinberg.gyp.gui.view.tree.filesystem;

import de.steinberg.gyp.gui.exception.PathComparisonException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by LKLeen on 19.12.2014.
 */
@Slf4j
public class PathComparisonEventHandler implements EventHandler<ActionEvent> {

    final PathTreeViewComparator comparator;

    protected PathComparisonEventHandler(PathTreeViewComparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public void handle(ActionEvent event) {
        log.info("triggered comparison {} to {}", comparator.parameters.getPath().toString(), comparator.parameters.getGypNode().getValue());
        try {
            comparator.call();
        } catch (Exception e) {
            throw new PathComparisonException(e);
        }
    }
}
