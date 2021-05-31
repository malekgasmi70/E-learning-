package BI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOFactory;
import DAO.*;
/**
 * Servlet implementation class Consulterform
 */
@WebServlet("/Consulterform")
public class Consulterform extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException { 
	    DAOFactory  daofactory= DAOFactory.getInstance(); 
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consulterform() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int idformateur = 0;
    this.getServletContext().getRequestDispatcher("/Formateur.jsp").forward(request, response); 
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
