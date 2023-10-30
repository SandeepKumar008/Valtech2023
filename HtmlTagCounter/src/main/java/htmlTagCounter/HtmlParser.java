package htmlTagCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {
    public static List<String> parseHtml(InputStream input) throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String line;
        int lineCount = 0;
        Pattern startTagPattern = Pattern.compile("<([^/][^>]*)>");
        Pattern endTagPattern = Pattern.compile("</([^>]*)>");

        int startTagCount = 0; // To count the start tags

        while ((line = reader.readLine()) != null) {
            lineCount++;
            Matcher startTagMatcher = startTagPattern.matcher(line);
            while (startTagMatcher.find()) {
                String startTag = startTagMatcher.group(1);
                result.add("Start Tag: " + startTag + " (Line " + lineCount + ")");
                startTagCount++;
            }

            Matcher endTagMatcher = endTagPattern.matcher(line);
            while (endTagMatcher.find()) {
                String endTag = endTagMatcher.group(1);
                result.add("End Tag: " + endTag + " (Line " + lineCount + ")");
            }
        }

        // Add the total start tag count to the result
        result.add("Total Start Tags: " + startTagCount);

        return result;
    }
}
