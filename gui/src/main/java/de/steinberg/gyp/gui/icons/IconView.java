package de.steinberg.gyp.gui.icons;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by LKLeen on 16.12.2014.
 */
public abstract class IconView extends ImageView {

    int height = 16;
    int width = 16;

    public IconView(Image image) {
        super(image);
        setFitHeight(height);
        setFitWidth(width);
    }
}
