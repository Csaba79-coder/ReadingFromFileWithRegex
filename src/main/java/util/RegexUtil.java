package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public String findMatch(String text, String regex) {
        //text.matches(regex);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }
}
