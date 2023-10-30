package firstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("User name ="+request.getParameter("name")+" Password = "+request.getParameter("pass"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * TODO if the name and password is wrong show the login page again with message
	 * if name is less than 4 chars then add a message and login page
	 * if pass is less than 8 chars then add message and login page
	 * all message should be in red
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		
		if (name.length() < 4) {
			 request.setAttribute("nameError", "Name should be at least 4 characters long");
			  request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	    if (pass.length() < 8) {
	        request.setAttribute("passError", "Password should be at least 8 characters long");
	    }
//	    if (!"scott".equals(name) || !"tiger123".equals(pass)) {
//	        request.setAttribute("loginError", "Invalid username or password");
//	    }

	    if (request.getAttribute("nameError") != null || request.getAttribute("passError") != null || request.getAttribute("loginError") != null) {
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    } 
	    else {
	        request.setAttribute("message", "Hi Scott.. How have you been");
	        request.getRequestDispatcher("loginresults.jsp").forward(request, response);
	    }
	}
}

