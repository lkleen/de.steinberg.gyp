package de.steinberg.gyp.gui.settings;

import javafx.scene.control.TextField;

import javax.inject.Inject;

/**
 * Created by LKLeen on 18.12.2014.
 */
public class SettingsTab {

    @Inject
    GuiSettingsHandler guiSettingsHandler;

    public void save(TextField text) {
        GuiSettings settings = guiSettingsHandler.read();
        settings.setRootPath(text.getText());
        guiSettingsHandler.write(settings);
    }

    public void load(TextField text) {
        GuiSettings settings = guiSettingsHandler.read();
        text.setText(settings.getRootPath());
    }

}
