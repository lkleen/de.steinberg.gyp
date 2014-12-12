package de.steinberg.gyp.core.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by LKLeen on 10.12.2014.
 */
@Data
public class GypFile {

    Map<String, List<String>> variables;

}
