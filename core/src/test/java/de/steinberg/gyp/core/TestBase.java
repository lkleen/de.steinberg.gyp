package de.steinberg.gyp.core;

import de.steinberg.gyp.core.configuration.ApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by LKLeen on 10.12.2014.
 */
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class TestBase extends AbstractTestNGSpringContextTests {
}
