package de.steinberg.gyp.parser.json;

import com.google.gson.Gson;
import de.steinberg.gyp.exception.ParserException;
import de.steinberg.gyp.model.GypFile;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by LKLeen on 11.12.2014.
 */
public class GypFileParser implements StreamParser<GypFile> {

    @Inject
    Gson gson;

    @Override
    public GypFile parse(InputStream input, Class<GypFile> type) {
        String inputString;
        try {
            inputString = read(input);
            inputString = removeTheAnnoyingComma(inputString);
            inputString = removeTheAnnoyingComma(inputString);
            return gson.fromJson(inputString, GypFile.class);
        } catch (Exception e) {
            throw new ParserException(e);
        }
    }

    private String removeTheAnnoyingComma(String inputString) {
        int index = inputString.lastIndexOf(",");
        String out = inputString.substring(0, index) + inputString.substring(index + 1, inputString.length());
        return out;
    }

    private String read(InputStream input) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = reader.readLine()) != null) {
            sb
                    .append(str)
                    .append("\n");
        }
        return sb.toString();
    }
}
