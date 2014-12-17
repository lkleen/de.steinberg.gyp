package de.steinberg.gyp.gui.configuration;

import de.steinberg.gyp.core.configuration.ApplicationConfiguration;
import de.steinberg.gyp.gui.icons.IconResolver;
import de.steinberg.gyp.gui.initializer.GypTreeViewInitializer;
import de.steinberg.gyp.gui.initializer.PathTreeViewInitializer;
import de.steinberg.gyp.gui.treeview.filesystem.PathNodeHandler;
import de.steinberg.gyp.gui.treeview.filesystem.PathTreeCellFactory;
import de.steinberg.gyp.gui.treeview.filesystem.RootNodeCreator;
import de.steinberg.gyp.gui.treeview.gypfile.GypNodeHandler;
import de.steinberg.gyp.gui.treeview.gypfile.GypTreeCellFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Configuration
@Import(ApplicationConfiguration.class)
public class GuiConfiguration {

    @Bean
    public GypNodeHandler gypNodeHandler() {return new GypNodeHandler();}

    @Bean
    public GypTreeCellFactory gypTreeCellFactory() {return new GypTreeCellFactory();}

    @Bean
    public GypTreeViewInitializer gypTreeViewInitializer() {return new GypTreeViewInitializer();}

    @Bean
    public PathTreeCellFactory pathTreeCellFactory() {return new PathTreeCellFactory();}

    @Bean
    public PathTreeViewInitializer pathTreeViewInitializer () {return new PathTreeViewInitializer();}

    @Bean
    public IconResolver iconResolver() {
        return new IconResolver();
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
