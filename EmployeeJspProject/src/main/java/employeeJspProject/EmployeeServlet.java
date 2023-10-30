package employeeJspProject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		private EmployeeDAO dao = new EmployeeTable();
		
	    public EmployeeServlet() {
	        super();
	    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String action = request.getServletPath();

			try {
				switch (action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					createEmployee(request, response);
					break;
				case "/delete":
					deleteEmployee(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					updateEmployee(request, response);
					break;
				case "/show":
					showForm(request, response);
					break;
				case "/view":
					updateEmployee(request, response);
					break;
				default:
					getAllEmployees(request, response);
					break;
				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		}

		private void getAllEmployees(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Employee> getAllEmployees = dao.getAllEmployees();
			request.setAttribute("getAllEmployees", getAllEmployees);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
			dispatcher.forward(request, response);
		}
		
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeForm.jsp");
			dispatcher.forward(request, response);
		}

		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int eid = Integer.parseInt(request.getParameter("eid"));
			Employee existingEmployee = dao.getEmployee(eid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeForm.jsp");
			request.setAttribute("Employee", existingEmployee);
			dispatcher.forward(request, response);

		}
		
		private void createEmployee(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int eid = Integer.parseInt(request.getParameter("eid"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			int experience = Integer.parseInt(request.getParameter("experience"));
			int seniority = Integer.parseInt(request.getParameter("seniority"));
			int salary = Integer.parseInt(request.getParameter("salary"));
			int did = Integer.parseInt(request.getParameter("did"));
			
			Employee emp = new Employee(eid,name, age, experience, seniority, salary, did);
			dao.createEmployee(emp);
			response.sendRedirect("list");
		}

		private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int eid = Integer.parseInt(request.getParameter("eid"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			int experience = Integer.parseInt(request.getParameter("experience"));
			int seniority = Integer.parseInt(request.getParameter("seniority"));
			int salary = Integer.parseInt(request.getParameter("salary"));
			int did = Integer.parseInt(request.getParameter("did"));

			Employee emp = new Employee(eid, name, age, experience, seniority, salary, did);
			dao.updateEmployee(emp);
			response.sendRedirect("list");
		}

		private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int eid = Integer.parseInt(request.getParameter("eid"));
			dao.deleteEmployee(eid);
			response.sendRedirect("list");

		}
		
		private void showForm(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int eid = Integer.parseInt(request.getParameter("eid"));
			Employee existingEmployee = dao.getEmployee(eid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
			request.setAttribute("Employee", existingEmployee);
			dispatcher.forward(request, response);

		}

}