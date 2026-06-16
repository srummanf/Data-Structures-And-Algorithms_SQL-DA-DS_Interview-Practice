import java.util.*;

public class PrettyJSON {
    public static ArrayList<String> prettyJSON(String str) {
        ArrayList<String> result = new ArrayList<>();
        int braceCount = 0;
        String currentLine = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '{' || ch == '[') {
                // If there's content in the current line, add it to the result
                if (!currentLine.isEmpty()) {
                    result.add(currentLine);
                    currentLine = "";
                }
                // Add the current character with indentation
                currentLine = getIndentation(braceCount) + ch;
                result.add(currentLine);
                currentLine = "";
                // Increase indentation level
                braceCount++;
            } else if (ch == '}' || ch == ']') {
                // If there's content in the current line, add it to the result
                if (!currentLine.isEmpty()) {
                    result.add(currentLine);
                    currentLine = "";
                }
                // Decrease indentation level
                braceCount--;
                // Add the current character with indentation
                currentLine = getIndentation(braceCount) + ch;
                // Check if next character is a comma and handle it on the same line
                if (i + 1 < str.length() && str.charAt(i + 1) == ',') {
                    currentLine += ',';
                    i++;
                }
                result.add(currentLine);
                currentLine = "";
            } else if (ch == ',') {
                // Add the comma to the current line
                currentLine += ch;
                // Add the current line to the result
                result.add(currentLine);
                currentLine = "";
            } else {
                // Add the character to the current line
                if (currentLine.isEmpty()) {
                    currentLine = getIndentation(braceCount);
                }
                currentLine += ch;
            }
        }
        // Add the last line if it's not empty
        if (!currentLine.isEmpty()) {
            result.add(currentLine);
        }

        return result;
    }

    private static String getIndentation(int level) {
        // Return a string with 'level' number of indentations (4 spaces each)
        String indentation = "";
        for (int i = 0; i < level; i++) {
            indentation += "    "; // Add 4 spaces for each indentation level
        }
        return indentation;
    }

    public static void main(String[] args) {
        List<String> inputs = Arrays.asList(
            "[{\"id\":1,\"first_name\":\"XC90\",\"last_name\":\"Portugal\"},{\"id\":2,\"first_name\":\"Borrego\",\"last_name\":\"France\"},{\"id\":3,\"first_name\":\"rio\",\"last_name\":\"Sweden\"}]",
            "[{\"id\":1,\"first_name\":\"C70\",\"last_name\":\"Comoros\"},{\"id\":2,\"first_name\":\"LX\",\"last_name\":\"AmericanSamoa\"},{\"id\":3,\"first_name\":\"911\",\"last_name\":\"Brazil\"}]",
            "[],{[]}",
            "[:]",
            "{}"
        );

        for (String input : inputs) {
            ArrayList<String> output = prettyJSON(input);
            for (String line : output) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}
