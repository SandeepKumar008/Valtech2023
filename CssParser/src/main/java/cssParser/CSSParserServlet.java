package cssParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class CSSParserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        //     Part filePart = request.getPart("cssFile");
      //     InputStream fileContent = filePart.getInputStream();
           Map<String, Map<String, String>> cssData = CSSParser.parseCSS(fileContent);
            request.setAttribute("cssData", cssData);

            request.getRequestDispatcher("result.jsp").forward(request, response);
         } catch (Exception e) {
             e.printStackTrace();
             response.getWriter().println("Error parsing CSS file.");
         }
}

