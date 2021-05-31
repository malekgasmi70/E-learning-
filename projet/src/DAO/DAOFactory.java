package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
private String url;
private String username; 
private String password;

DAOFactory(String url, String username, String password) { 
this.url = url; 
this.username = username; 
this.password = password; 
	}
	 public static DAOFactory getInstance() { 
	     try { 
	         Class.forName("com.mysql.jdbc.Driver"); 
	     } catch (ClassNotFoundException e) {
	}
	DAOFactory instance = new DAOFactory("jdbc:mysql://localhost:3306/notre_projet", "root", ""); 
	return instance; 
	 } 
	 
	 
	 public Connection getConnection() throws SQLException { 
	     return DriverManager.getConnection(url, username, password);
	 }
	 
	// Récupération du Dao public UtilisateurDao getUtilisateurDao() { return new UtilisateurDaoImpl(this); }

	public ApprenantDAO getApprenant() { 
	    return new ApprenantDAOImpl(this); 
	}
	
	public CoursDAO getCoursDAO() {
		return new CoursDAOImpl(this);
	}
    public RejoindreDAO getRejoindreDAO() {
	    return new RejoindreDAOImpl(this);
}
    
	
	public SinscrireDAO getSinscrireDAO() {
	    return new SinscrireDAOImpl(this); 
	}
	public FormationDAO getFormationDAO() {
	    return new FormationDAOImpl1(this);
	}
	
	public TousformationDAO getTousformationDAO() {
	    return new TousformationDAOImpl(this);
		
	}
	}


