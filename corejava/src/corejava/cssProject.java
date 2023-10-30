package corejava;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class cssProject {
    public static void main(String[] args) {
        try {
            String fileName = "C:\\Users\\KavyashreeR\\eclipse-workspace\\corejava\\src\\corejava\\NewFile.css"; // Replace with your CSS file path
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder cssContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                cssContent.append(line).append("\n");
            }
            br.close();
            // Define regular expressions for class selectors, int attributes, and hex color attributes
            String classSelectorRegex = "\\.([a-zA-Z0-9_-]+)\\s*\\{";
            String intAttributeRegex = "([a-zA-Z-]+)\\s*:\\s*([0-9]+);";
            String hexColorAttributeRegex = "([a-zA-Z-]+)\\s*:\\s*#([0-9a-fA-F]+);";
            // Compile the regular expressions
            Pattern classSelectorPattern = Pattern.compile(classSelectorRegex);
            Pattern intAttributePattern = Pattern.compile(intAttributeRegex);
            Pattern hexColorAttributePattern = Pattern.compile(hexColorAttributeRegex);
            // Match and extract class selectors and attributes
            Matcher classSelectorMatcher = classSelectorPattern.matcher(cssContent);
            while (classSelectorMatcher.find()) {
String classSelector = classSelectorMatcher.group(1);
                System.out.println("Class Selector: " + classSelector);
                // Now, within the class selector, search for int attributes and hex color attributes
                int startIndex = classSelectorMatcher.end();
                int endIndex = cssContent.indexOf("}", startIndex);
                String classContent = cssContent.substring(startIndex, endIndex);
                Matcher intAttributeMatcher = intAttributePattern.matcher(classContent);
                while (intAttributeMatcher.find()) {
String attributeName = intAttributeMatcher.group(1);
int attributeValue = Integer.parseInt(intAttributeMatcher.group(2));
                    System.out.println("Int Attribute: " + attributeName + " = " + attributeValue);
                }
                Matcher hexColorAttributeMatcher = hexColorAttributePattern.matcher(classContent);
                while (hexColorAttributeMatcher.find()) {
String attributeName = hexColorAttributeMatcher.group(1);
String hexValue = hexColorAttributeMatcher.group(2);
                    String rgbValue = hexToRgb(hexValue);
                    System.out.println("Hex Color Attribute: " + attributeName + " = " + rgbValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String hexToRgb(String hex) {
        int colorValue = Integer.parseInt(hex, 16);
        int red = (colorValue >> 16) & 0xFF;
        int green = (colorValue >> 8) & 0xFF;
        int blue = colorValue & 0xFF;
        return "rgb(" + red + "," + green + "," + blue + ")";
    }
}