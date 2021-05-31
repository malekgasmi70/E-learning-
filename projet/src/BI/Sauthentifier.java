package BI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Apprenant;
import Beans.Formateur;
import DAO.*;


/**
 * Servlet implementation class login_serv
 */
@WebServlet("/Sauthentifier")
public class Sauthentifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
    private DAO.SauthentifierDAOform SauthentifierDAOform;
    private DAO.SauthentifierDAOapp SauthentifierDAOapp;
    private DAO.SessionformateurDAO SessionformateurDAO;
	private TousformationDAO TousformationDAO;
	private FormationDAO FormationDAO;
    public void init() throws ServletException {
    	 DAOFactory  daofactory= DAOFactory.getInstance(); 
 	    this.FormationDAO = daofactory.getFormationDAO();
 	    this.TousformationDAO = daofactory.getTousformationDAO();
    	SauthentifierDAOform = new DAO.SauthentifierDAOform();
    	SessionformateurDAO = new DAO.SessionformateurDAO();
    	SauthentifierDAOapp = new DAO.SauthentifierDAOapp();
    }

    public Sauthentifier() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = (String) request.getParameter("type"); 
		String email = (String) request.getParameter("email");
		String password =(String) request.getParameter("password");
		Formateur Form  = new Formateur();
		Form.setEmail(email);
		Form.setPassword(password);
	
		Apprenant app  = new Apprenant();
		app.setEmail(email);
		app.setPassword(password);

		try {
			if (type.equals("option1") && SauthentifierDAOform.validate(Form)) {
				Formateur Form1 = (Formateur) SessionformateurDAO.Npr(email, password);
				HttpSession session = request.getSession();
				session.setAttribute("nom",Form1.getNomfr());
				session.setAttribute("prenom",Form1.getPrenom());
				session.setAttribute("idformateur",Form1.getIdformateur());
				String idfor = String.valueOf(Form1.getIdformateur()); 
				session.setAttribute("Formations", FormationDAO.consulter(idfor));	
				response.sendRedirect("Formateur.jsp");
			} 
			else if(type.equals("option2") && SauthentifierDAOapp.validate(app)) {
				Apprenant app1 = (Apprenant) SessionapprenantDAO.Npr(email, password);
				HttpSession session = request.getSession();
				session.setAttribute("nom",app1.getNom());
				session.setAttribute("prenom",app1.getPrenom());
				session.setAttribute("idapprenant",app1.getIdapprenant());
				session.setAttribute("Formations", TousformationDAO.consulter1(app1.getIdapprenant()));
				session.setAttribute("Mesformations", TousformationDAO.consulter2(app1.getIdapprenant()));
				response.sendRedirect("Apprenant.jsp");
				
			}
			else {
				response.sendRedirect("login.jsp");
				}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
	

}


	
	}