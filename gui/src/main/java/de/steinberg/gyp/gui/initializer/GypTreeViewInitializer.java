package de.steinberg.gyp.gui.initializer;

import de.steinberg.gyp.core.exception.ParserException;
import de.steinberg.gyp.core.interpreter.GypFileInterpreter;
import de.steinberg.gyp.core.json.GypFileParser;
import de.steinberg.gyp.core.model.GypFile;
import de.steinberg.gyp.core.model.GypFileTree;
import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.gui.dialog.FileSelector;
import de.steinberg.gyp.gui.exception.GypFileParsingException;
import de.steinberg.gyp.gui.treeview.gypfile.GypTreeCellFactory;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Slf4j
public class GypTreeViewInitializer {

    @Inject
    GypFileParser gypFileParser;

    @Inject
    GypFileInterpreter gypFileInterpreter;

    @Inject
    GypTreeCellFactory gypTreeCellFactory;

    @Inject
    FileSelector fileSelector;

    public void initialize(TreeView<GypNode> treeView) {
        Path path = fileSelector.showOpenDialog();

        if(path == null)
            return;

        GypFile gypFile = parseFile(path);

        if (gypFile == null)
            return;

        GypFileTree gypFileTree = gypFileInterpreter.getFilesListFrom(path.toAbsolutePath().toString(), gypFile);
        TreeItem<GypNode> root = new TreeItem<>(gypFileTree.getRoot());
        treeView.setCellFactory(gypTreeCellFactory);
        treeView.setRoot(root);

    }

    private GypFile parseFile(Path path) {
        try (InputStream is = Files.newInputStream(path)) {
            return gypFileParser.parse(is, GypFile.class);
        } catch (IOException e) {
            throw new GypFileParsingException(e);
        } catch (ParserException e) {
            log.warn("could not parse {}", path.toString());
            return null;
        }
    }

}
