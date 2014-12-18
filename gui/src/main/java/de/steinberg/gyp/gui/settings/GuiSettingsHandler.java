package de.steinberg.gyp.gui.settings;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

/**
 * Created by LKLeen on 18.12.2014.
 */
@Slf4j
public class GuiSettingsHandler {

    private static final String filename = "settings.json";

    @Inject
    FileSystem fileSystem;

    @Inject
    Gson gson;

    GuiSettings guiSettings;

    public GuiSettings read() {
        if (guiSettings == null) {
            guiSettings = readSettings();
        }
        return guiSettings;
    }

    private GuiSettings readSettings() {
        Path path = fileSystem.getPath(filename);
        if (!Files.exists(path)) {
            return new GuiSettings();
        } else {
            try {
                GuiSettings result = gson.fromJson(Files.newBufferedReader(path), GuiSettings.class);
                return result == null ? new GuiSettings() : result;
            } catch (IOException e) {
                log.error(e.getMessage());
                return new GuiSettings();
            }
        }
    }

    public void write(GuiSettings guiSettings) {
        Path path = fileSystem.getPath(filename);
        try {
            String json = gson.toJson(guiSettings);
            OutputStreamWriter osw = new OutputStreamWriter(Files.newOutputStream(path));
            gson.toJson(guiSettings, osw);
            osw.close();
        } catch (IOException e) {
            log.error("could not write settings {}", e.getMessage());
        }
    }

}
