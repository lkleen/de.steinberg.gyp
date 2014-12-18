package de.steinberg.gyp.gui.controller;

import de.steinberg.gyp.core.model.GypNode;
import de.steinberg.gyp.gui.initializer.GypTreeViewInitializer;
import de.steinberg.gyp.gui.initializer.PathTreeViewInitializer;
import de.steinberg.gyp.gui.settings.SettingsTab;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;
import javafx.stage.Window;
import lombok.extern.slf4j.Slf4j;

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

    public void postConstruct() throws Exception {
        pathTreeViewInitializer.initialize(pathTreeView);
        settingsTab.load(settingsRoot);
    }

    @FXML
    public void openFileChooser() {
        gypTreeViewInitializer.initialize(gypTreeView);
    }

    @FXML
    public void saveSettings() {
        settingsTab.save(settingsRoot);
    }

}
