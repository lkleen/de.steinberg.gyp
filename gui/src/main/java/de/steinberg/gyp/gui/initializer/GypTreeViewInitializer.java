package de.steinberg.gyp.gui.initializer;

import de.steinberg.gyp.core.interpreter.GypFileInterpreter;
import de.steinberg.gyp.core.json.GypFileParser;
import de.steinberg.gyp.core.model.GypFile;
import de.steinberg.gyp.core.model.GypFileTree;
import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.gui.exception.GypFileParsingException;
import de.steinberg.gyp.gui.treeview.gypfile.GypTreeCellFactory;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by LKLeen on 17.12.2014.
 */
public class GypTreeViewInitializer {

    @Inject
    GypFileParser gypFileParser;

    @Inject
    GypFileInterpreter gypFileInterpreter;

    @Inject
    GypTreeCellFactory gypTreeCellFactory;

    public void initialize(TreeView<GypNode> treeView) {
        Path path = selectFile();
        GypFile gypFile = parseFile(path);
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
        }
    }

    private Path selectFile() {
        FileChooser fs = new FileChooser();
        fs.setInitialDirectory(new File("S:\\svn\\steinberg\\_users\\MotorTeam\\branches\\C850_D\\sequencer"));
        File file = fs.showOpenDialog(null);
        return file.toPath();
    }

}
