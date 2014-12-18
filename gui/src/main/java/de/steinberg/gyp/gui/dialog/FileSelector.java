package de.steinberg.gyp.gui.dialog;

import de.steinberg.gyp.gui.settings.GuiSettings;
import de.steinberg.gyp.gui.settings.GuiSettingsHandler;
import javafx.stage.FileChooser;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.File;
import java.nio.file.Path;

/**
 * Created by LKLeen on 18.12.2014.
 */
@Slf4j
public class FileSelector {

    @Inject
    GuiSettingsHandler guiSettingsHandler;

    public Path showOpenDialog() {
        GuiSettings settings = guiSettingsHandler.read();

        File selectedFile = openDialog(settings);

        if (selectedFile != null && selectedFile.isFile())
        {
            settings.setInitialDirectory(selectedFile.getParentFile());
            settings.setInitialFilename(selectedFile.getName());
            guiSettingsHandler.write(settings);
            return selectedFile.toPath();
        } else {
            return null;
        }
    }

    private File openDialog(GuiSettings settings) {

        File selectedFile;
        File initialDirectory = settings.getInitialDirectory();
        String initialFilename = settings.getInitialFilename();
        FileChooser fileChooser = new FileChooser();

        if (initialDirectory != null && initialDirectory.isDirectory()) {
            File file = new File(initialDirectory.toString()); // why this workaround?
            // because if I do not copy the file here for some reason
            // getCanonicalPath called from FileChooser will fail
            // after loading the settings with gson
            fileChooser.setInitialDirectory(file);
            fileChooser.setInitialFileName(initialFilename);
        }

        try {
            selectedFile = fileChooser.showOpenDialog(null);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("could not open filechooser with initial file {}", initialDirectory);
            fileChooser.setInitialDirectory(null);
            fileChooser.setInitialFileName(null);
            selectedFile = fileChooser.showOpenDialog(null);
        }
        return selectedFile;
    }
}
