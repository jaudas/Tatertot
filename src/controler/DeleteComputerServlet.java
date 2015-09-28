package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ComputerService;
import service.ComputerServiceImpl;

@WebServlet("/DeleteComputerServlet")
public class DeleteComputerServlet extends  HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComputerService computerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteComputerServlet() {
		super();
		computerService = ComputerServiceImpl.getInstance();
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Get a service
		computerService = ComputerServiceImpl.getInstance();

		String id = req.getParameter("delete");
		if(id!=null){
			computerService.delete(Long.valueOf(id));
		}
		

	}
}
