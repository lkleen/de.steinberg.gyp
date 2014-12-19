package de.steinberg.gyp.gui.exception;

import de.steinberg.gyp.core.exception.ApplicationException;

/**
 * Created by LKLeen on 17.12.2014.
 */
public class GuiException extends ApplicationException {
    public GuiException(Throwable cause) {
        super(cause);
    }

    public GuiException(String message) {
        super(message);
    }
}
