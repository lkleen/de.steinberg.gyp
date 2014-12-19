package de.steinberg.gyp.gui.logging;

import de.steinberg.gyp.gui.FXMLElementsAccessor;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import javax.inject.Inject;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by LKLeen on 19.12.2014.
 */
public class LogWriter extends Writer {

    final TextArea logOutput;

    public LogWriter(TextArea logOutput) {
        this.logOutput = logOutput;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        String text = new String(cbuf, off, len);
        logOutput.appendText(text);
    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}
