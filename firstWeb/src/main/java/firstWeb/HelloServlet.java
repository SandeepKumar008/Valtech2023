package firstWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	private int count;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init of the Hello server");
		System.out.println("Driver Class = "+config.getInitParameter("driver-class"));
		System.out.println("jdbc Url = "+config.getInitParameter("jdbc-url"));
		System.out.println("Username = "+config.getInitParameter("username"));
		System.out.println("Password = "+config.getInitParameter("password"));



	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.getWriter().print("Hello World "+ count++);
		
		String name = req.getParameter("name");
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		
		out.print("<head>");
		out.print("<title>");
		out.print("Hello"+name);

		out.print("</title>");

		out.print("</head>");
		out.print("<body>");
		
		out.print("Hello <b>" +name+"</b> <br/>");
		out.print("you are visitor no "+count+" for this website");

		
		out.print("</body>");


		out.print("</html>");

		
		}
	
	
	@Override
	public void destroy() {
		System.out.println("destroy count = "+ count);
	}

}
