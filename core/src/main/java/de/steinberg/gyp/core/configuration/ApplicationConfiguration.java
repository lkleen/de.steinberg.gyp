package de.steinberg.gyp.core.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.steinberg.gyp.core.filesystem.FileSetComparator;
import de.steinberg.gyp.core.filesystem.FileSystemAccessor;
import de.steinberg.gyp.core.interpreter.GypFileTreeParser;
import de.steinberg.gyp.core.interpreter.GypFileInterpreter;
import de.steinberg.gyp.core.json.GypFileParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 *
 * Created by LKLeen on 10.12.2014.
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public FileSetComparator fileSetComparator() {return new FileSetComparator();}

    @Bean
    public FileSystem fileSystem() {return FileSystems.getDefault();}

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .serializeNulls()
                .create();
    }

    @Bean
    public GypFileParser gypFileParser() {
        return new GypFileParser();
    }

    @Bean
    public FileSystemAccessor fileSystemAccessor() {return new FileSystemAccessor();}

    @Bean
    public GypFileInterpreter gypFileInterpreter() {return new GypFileInterpreter();}

    @Bean
    public GypFileTreeParser gypFileEntryParser() {return new GypFileTreeParser();}
}
