package de.steinberg.gyp.gui.controller;

import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.gui.FXMLElementsAccessor;
import de.steinberg.gyp.gui.dialog.FileSelector;
import de.steinberg.gyp.gui.exception.GypTreeViewInitializationException;
import de.steinberg.gyp.gui.initializer.GypTreeViewInitializer;
import de.steinberg.gyp.gui.initializer.PathTreeViewInitializer;
import de.steinberg.gyp.gui.logging.LogAppender;
import de.steinberg.gyp.gui.logging.LogWriter;
import de.steinberg.gyp.gui.settings.GuiSettingsHandler;
import de.steinberg.gyp.gui.settings.SettingsTab;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;
import javafx.stage.Window;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import java.nio.file.Path;

/**
 * Created by LKLeen on 16.12.2014.
 */
@Slf4j
public class Controller {

    @Inject
    PathTreeViewInitializer pathTreeViewInitializer;

    @FXML
    TreeView<Path> pathTreeView;

    @Inject
    GypTreeViewInitializer gypTreeViewInitializer;

    @FXML
    TreeView<GypNode> gypTreeView;

    @FXML
    TextField settingsRoot;

    @Inject
    SettingsTab settingsTab;

    @Inject
    FileSelector fileSelector;

    @Inject
    GuiSettingsHandler guiSettingsHandler;

    @Inject
    FXMLElementsAccessor fxmlElementsAccessor;

    @FXML
    TextArea logOutput;

    public void postConstruct() throws Exception {
        Logger.getLogger("de.steinberg").addAppender(new LogAppender(new LogWriter(logOutput)));

        fxmlElementsAccessor.setGypTreeView(gypTreeView);
        fxmlElementsAccessor.setPathTreeView(pathTreeView);
        fxmlElementsAccessor.setLogOutput(logOutput);

        settingsTab.load(settingsRoot);

        initializeTrees(gypTreeView, guiSettingsHandler.read().getInitialFile().toPath());
    }

    @FXML
    public void openFileChooser() {
        Path path = fileSelector.showOpenDialog();
        initializeTrees(gypTreeView, path);
    }

    private void initializeTrees(TreeView<GypNode> gypTreeView, Path path) {
        try {
            gypTreeViewInitializer.initialize(gypTreeView, path);
            pathTreeViewInitializer.initialize(pathTreeView);
            log.info("opened {}", path.toString());
        } catch (GypTreeViewInitializationException e)
        {
            log.warn("could not load {} {}", path.toString(), e.getMessage());
            gypTreeView.setRoot(null);
            pathTreeViewInitializer.initialize(pathTreeView);
        }
    }

    @FXML
    public void saveSettings() {
        settingsTab.save(settingsRoot);
    }

}
