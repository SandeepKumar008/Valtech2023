package cssParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSSParser {
    public static Map<String, Map<String, String>> parseCSS(InputStream string) {
        Map<String, Map<String, String>> cssData = new HashMap<>();
        Pattern selectorPattern = Pattern.compile("(\\.[\\w-]+)\\s*\\{([^}]+)}");
        Pattern propertyPattern = Pattern.compile("([^:]+):([^;]+);");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(string));
            String line;
            String currentSelector = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith(".")) {
                    Matcher selectorMatcher = selectorPattern.matcher(line);
                    if (selectorMatcher.matches()) {
                        currentSelector = selectorMatcher.group(1);
                        cssData.put(currentSelector, new HashMap<>());
                    }
                } else if (currentSelector != null) {
                    Matcher propertyMatcher = propertyPattern.matcher(line);
                    while (propertyMatcher.find()) {
                        String propertyName = propertyMatcher.group(1).trim();
                        String propertyValue = propertyMatcher.group(2).trim();
                        cssData.get(currentSelector).put(propertyName, propertyValue);
                    }
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cssData;
    }
}

