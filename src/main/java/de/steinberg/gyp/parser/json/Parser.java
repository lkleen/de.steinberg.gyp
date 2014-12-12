package de.steinberg.gyp.parser.json;

/**
 * Created by LKLeen on 11.12.2014.
 */
public interface Parser<I, O> {

    O parse (I input, Class<O> type);

}
