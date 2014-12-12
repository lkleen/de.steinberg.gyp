package de.steinberg.gyp.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.steinberg.gyp.parser.json.GypFileParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LKLeen on 10.12.2014.
 */
@Configuration
public class ApplicationConfiguration {

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

}
