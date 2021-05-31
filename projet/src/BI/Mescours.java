package BI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;

/**
 * Servlet implementation class Modifier
 */
@WebServlet("/Mescours")
public class Mescours extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RejoindreDAO RejoindreDAO;
	private TousformationDAO TousformationDAO;
	public void init() throws ServletException { 
	    DAOFactory  daofactory= DAOFactory.getInstance(); 
	    this.RejoindreDAO = daofactory.getRejoindreDAO();
 	    this.TousformationDAO = daofactory.getTousformationDAO();

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mescours() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idformation =(String) request.getParameter("custId1"); 	
		String idapprenant = (String)request.getParameter("custId2"); 
		int idapp = Integer.parseInt(idapprenant);
		int idform = Integer.parseInt(idformation);
		RejoindreDAO.ajouter(idapp, idform);
		HttpSession session = request.getSession();
		session.setAttribute("Formations", TousformationDAO.consulter1(idapp));
		session.setAttribute("Mesformations", TousformationDAO.consulter2(idapp));
		this.getServletContext().getRequestDispatcher("/Apprenant.jsp").forward(request, response);

	}

}
