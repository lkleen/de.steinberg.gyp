package de.steinberg.gyp.gui.configuration;

import de.steinberg.gyp.core.configuration.ApplicationConfiguration;
import de.steinberg.gyp.gui.FXMLElementsAccessor;
import de.steinberg.gyp.gui.dialog.FileSelector;
import de.steinberg.gyp.gui.icons.IconResolver;
import de.steinberg.gyp.gui.initializer.GypTreeViewInitializer;
import de.steinberg.gyp.gui.initializer.PathTreeViewInitializer;
import de.steinberg.gyp.gui.settings.GuiSettingsHandler;
import de.steinberg.gyp.gui.settings.SettingsTab;
import de.steinberg.gyp.gui.view.result.ComparisonResultView;
import de.steinberg.gyp.gui.view.tree.filesystem.*;
import de.steinberg.gyp.gui.view.tree.gypfile.GypNodeHandler;
import de.steinberg.gyp.gui.view.tree.gypfile.GypTreeCellFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * Created by LKLeen on 17.12.2014.
 */
@Configuration
@Import(ApplicationConfiguration.class)
public class GuiConfiguration {

    @Bean
    public ComparisonResultView comparisonResultView() {return new ComparisonResultView();}

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PathTreeViewComparator pathTreeViewComparator() {return new PathTreeViewComparator();}

    @Bean
    public PathTreeCellContextMenuFactory pathTreeCellContextMenuFactory() {return new PathTreeCellContextMenuFactory() {
        @Override
        protected PathTreeViewComparator createComparator() {
            return pathTreeViewComparator();
        }
    };}

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
