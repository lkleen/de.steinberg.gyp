package de.steinberg.gyp.gui.logging;

import de.steinberg.gyp.gui.FXMLElementsAccessor;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import javax.inject.Inject;

/**
 * Created by LKLeen on 19.12.2014.
 */
public class LogAppender extends WriterAppender {

    public LogAppender(LogWriter logWriter) {
        super(new SimpleLayout(), logWriter);
    }



}
