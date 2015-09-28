package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComputerDao;
import dao.ComputerDaoImpl;
import model.Computer;
import service.ComputerService;
import service.ComputerServiceImpl;

@WebServlet("/ComputerServlet")
public class ComputerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3809639866338168729L;
	private ComputerService computerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComputerServlet() {
		super();
		computerService = ComputerServiceImpl.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String searchString = request.getParameter("searchString");
		System.out.println("SearchString = " + searchString);
		
		int page = 1;
		int computersPerPage = 20;
		
		if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
		
		ComputerDao cDAO = ComputerDaoImpl.getInstance();
		
		List<Computer> listComputer = cDAO.getAll((page-1)*computersPerPage,
                computersPerPage, searchString);
		int noOfRecords = cDAO.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / computersPerPage);

		request.setAttribute("computers", listComputer);
		request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/jsp/dashboard.jsp"));
		rd.forward(request, response);
	}

}
