package de.steinberg.gyp.gui.configuration;

import de.steinberg.gyp.core.configuration.ApplicationConfiguration;
import de.steinberg.gyp.gui.FXMLElementsAccessor;
import de.steinberg.gyp.gui.dialog.FileSelector;
import de.steinberg.gyp.gui.icons.IconResolver;
import de.steinberg.gyp.gui.initializer.GypTreeViewInitializer;
import de.steinberg.gyp.gui.initializer.PathTreeViewInitializer;
import de.steinberg.gyp.gui.settings.GuiSettingsHandler;
import de.steinberg.gyp.gui.settings.SettingsTab;
import de.steinberg.gyp.gui.view.tree.filesystem.PathNodeHandler;
import de.steinberg.gyp.gui.view.tree.filesystem.PathTreeCellContextMenuFactory;
import de.steinberg.gyp.gui.view.tree.filesystem.PathTreeCellFactory;
import de.steinberg.gyp.gui.view.tree.filesystem.RootNodeCreator;
import de.steinberg.gyp.gui.view.tree.gypfile.GypNodeHandler;
import de.steinberg.gyp.gui.view.tree.gypfile.GypTreeCellFactory;
import de.steinberg.gyp.gui.view.tree.layout.TreeCellLayoutHandler;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Configuration
@Import(ApplicationConfiguration.class)
public class GuiConfiguration {

    @Bean
    public TreeCellLayoutHandler treeCellLayoutHandler() {return new TreeCellLayoutHandler();}

    @Bean
    public FloatProperty floatProperty() {return new SimpleFloatProperty(1F);}

    @Bean
    public PathTreeCellContextMenuFactory pathTreeCellContextMenuFactory() {return new PathTreeCellContextMenuFactory();}

    @Bean
    public FXMLElementsAccessor fxmlElementsAccessor() {return new FXMLElementsAccessor();}

    @Bean
    public SettingsTab settingsTab() {return new SettingsTab();}

    @Bean
    public FileSelector fileSelector() {return new FileSelector();}

    @Bean
    public GuiSettingsHandler guiSettingsHandler() {return new GuiSettingsHandler();}

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
