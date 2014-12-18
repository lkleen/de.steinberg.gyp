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
            settings.setInitialFile(selectedFile);
            guiSettingsHandler.write(settings);
            return selectedFile.toPath();
        } else {
            return null;
        }
    }

    private File openDialog(GuiSettings settings) {

        File selectedFile;
        File initialFile = settings.getInitialFile();


        File initialDirectory = (initialFile != null) ? initialFile.getParentFile() : null;
        String initialFilename = (initialFile != null) ? initialFile.getName() : null;
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
