package de.steinberg.gyp.gui.configuration;

import de.steinberg.gyp.gui.icons.IconResolver;
import de.steinberg.gyp.gui.treeview.filesystem.PathNodeHandler;
import de.steinberg.gyp.gui.treeview.filesystem.PathTreeCellFactory;
import de.steinberg.gyp.gui.treeview.filesystem.RootNodeCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Configuration
public class GuiConfiguration {

    @Bean
    public PathTreeCellFactory pathTreeCellFactory() {return new PathTreeCellFactory();}

    @Bean
    public IconResolver iconResolver() {
        return new IconResolver();
    }

    @Bean
    public FileSystem fileSystem () {
        return FileSystems.getDefault();
    }

    @Bean
    public PathNodeHandler pathNodeHandler() {
        return new PathNodeHandler();
    }

    @Bean
    public RootNodeCreator rootNodeCreator () {
        return new RootNodeCreator();
    }

}
