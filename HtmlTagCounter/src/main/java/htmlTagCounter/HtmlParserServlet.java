package htmlTagCounter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/HtmlParserServlet")
@MultipartConfig
public class HtmlParserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("htmlFile");
        InputStream fileContent = filePart.getInputStream();
        
        List<String> result = HtmlParser.parseHtml(fileContent);
        
        request.setAttribute("tags", result);
        request.getRequestDispatcher("results.jsp").forward(request, response);
    }
}
