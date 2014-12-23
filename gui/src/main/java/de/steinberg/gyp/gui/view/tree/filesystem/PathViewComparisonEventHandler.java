package de.steinberg.gyp.gui.view.tree.filesystem;

import de.steinberg.gyp.core.model.GypNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by LKLeen on 19.12.2014.
 */
@Slf4j
public class PathViewComparisonEventHandler implements EventHandler<ActionEvent> {

    final GypNode gypNode;
    final PathView pathView;

    float value = 0F;

    public PathViewComparisonEventHandler(GypNode gypNode, PathView pathView) {
        this.gypNode = gypNode;
        this.pathView = pathView;
    }

    @Override
    public void handle(ActionEvent event) {
        value += 10;
        pathView.getCorrelation().set(value);
        log.info("{}", pathView.toString());
    }
}
