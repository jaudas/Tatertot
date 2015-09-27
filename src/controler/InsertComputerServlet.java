package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Computer;
import service.ComputerService;
import service.ComputerServiceImpl;

@WebServlet("/InsertComputerServlet")
public class InsertComputerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComputerService computerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertComputerServlet() {
		super();
		computerService = ComputerServiceImpl.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				response.encodeURL("/WEB-INF/jsp/addComputer.jsp"));
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nameComputer = (String) request.getParameter("name");
		// Date introduced = (Date) request.getParameter("introduced");
		// Date discontinued = (Date) request.getParameter("discontinued");
		// Company company = (String) request.getParameter("company");

		Computer computer = new Computer();
		computer.setNameComputer(nameComputer);
		// computer.setIntroduced(introduced);
		// computer.setDiscontinued(discontinued);
		// computer.setCompany(company);
		computerService.insert(computer);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				response.encodeURL("/WEB-INF/jsp/addComputer.jsp"));
	}
}
