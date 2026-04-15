

package chatbot.functions;

import java.io.*;
import java.util.regex.*;

public class FileFind {
    
// Method to search for a query in a specific file
    public String search(String query, String fileName) {
        // Regex: Case-insensitive search for the query anywhere in a line
        // Pattern.quote ensures user symbols don't break the regex
        Pattern pattern = Pattern.compile(".*" + Pattern.quote(query.trim()) + ".*", Pattern.CASE_INSENSITIVE);
        
        File file = new File(fileName);
        if (!file.exists()) {
            return "Error: " + fileName + " not found.";
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher m = pattern.matcher(line);
                if (m.matches()) {
                    return "Found: " + line;
                }
            }
        } catch (IOException e) {
            return "Error reading the file.";
        }

        return "No match found for: " + query;
    }
}
    

