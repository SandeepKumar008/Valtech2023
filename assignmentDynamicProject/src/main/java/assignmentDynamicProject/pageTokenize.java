package assignmentDynamicProject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pageTokenize extends HttpServlet {

    private String websiteURL = "https://en.wikipedia.org/wiki/English_Wikipedia"; // Default URL

    // Setter method for the website URL
    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            URL url = new URL(websiteURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            try (FileWriter fileWriter = new FileWriter("output.txt")) {
                fileWriter.write(content.toString());
            }

            // Read the file
            BufferedReader fileReader = new BufferedReader(new FileReader("output.txt"));
            String line;
            StringBuilder text = new StringBuilder();
            while ((line = fileReader.readLine()) != null) {
                text.append(line);
            }
            fileReader.close();

            // Tokenize the words
            String[] words = text.toString().split("\\s+");

            // Eliminate common words
            List<String> commonWords = Arrays.asList("the", "and", "a", "an"); // Add more as needed
            List<String> uncommonWords = new ArrayList<>();
            for (String word : words) {
                if (!commonWords.contains(word.toLowerCase())) {
                    uncommonWords.add(word);
                }
            }

            // Count the uncommon words
            int count = uncommonWords.size();

            // Display the count (For demonstration purposes)
            System.out.println("The count of uncommon words is: " + count);

            // Write the count as a response
            response.getWriter().write("The count of uncommon words is: " + count);

        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().write("An error occurred during tokenization.");
        }
    }
}