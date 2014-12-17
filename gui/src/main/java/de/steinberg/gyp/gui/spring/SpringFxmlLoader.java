package de.steinberg.gyp.gui.spring;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by LKLeen on 17.12.2014.
 */
public class SpringFxmlLoader {
    private ApplicationContext context;

    public SpringFxmlLoader(ApplicationContext context)
    {
        this.context = context;
    }

    public Object load(String name, Class<?> controllerClass) throws IOException
    {
        try (InputStream fxmlStream = ClassLoader.getSystemResourceAsStream(name))
        {
            Object instance = context.getBean(controllerClass);
            FXMLLoader loader = new FXMLLoader();
            loader.getNamespace().put("controller", instance);
            return loader.load(fxmlStream);
        }
    }
}
