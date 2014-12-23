package de.steinberg.gyp.gui.view.result;

import de.steinberg.gyp.gui.FXMLElementsAccessor;
import de.steinberg.gyp.gui.view.tree.filesystem.PathTreeViewComparator;
import javafx.scene.control.TextArea;

import javax.inject.Inject;

/**
 * Created by LKLeen on 23.12.2014.
 */
public class ComparisonResultView {

    @Inject
    FXMLElementsAccessor fxmlElementsAccessor;

    public void print(PathTreeViewComparator.Result result) {
        TextArea textArea = fxmlElementsAccessor.getComparisonResult();
        textArea.clear();
        appendMissingInFilesSystem(textArea, result);
        appendMissingInConfiguration(textArea, result);
    }

    private void appendMissingInConfiguration(TextArea output, PathTreeViewComparator.Result result) {
        output.appendText("files missing in configuration:\n");
        output.appendText(result.getFilesMissingInConfiguration().toString() + "\n");
    }

    private void appendMissingInFilesSystem(TextArea output, PathTreeViewComparator.Result result) {
        output.appendText("files missing in filesystem:\n");
        output.appendText(result.getFilesMissingInFilesystem().toString() + "\n");
    }

}
