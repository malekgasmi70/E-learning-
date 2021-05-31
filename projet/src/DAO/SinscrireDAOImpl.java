package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Beans.Apprenant;
import Beans.Formateur;

public class SinscrireDAOImpl implements SinscrireDAO {
	private DAOFactory daoFactory; 
	SinscrireDAOImpl(DAOFactory daoFactory) { 
        this.daoFactory = daoFactory;
    }
	@Override
	public void sinscrire_App(Apprenant App) {
		Connection connexion = null; 
	     PreparedStatement preparedStatement = null; 
	        try { 
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO apprenant(nom, prenom, date_naissance, email, password) VALUES(?, ?, ?, ?, ?)"); 
	            preparedStatement.setString(1,App.getNom()); 
	            preparedStatement.setString(2,App.getPrenom());
	            preparedStatement.setString(3,App.getDate_naissance());
	            preparedStatement.setString(4,App.getEmail());
	            preparedStatement.setString(5,App.getPassword());
	            preparedStatement.executeUpdate(); 
	        } catch (SQLException e) { 
	            e.printStackTrace();
	        
	}
	}
	@Override
	public void sinscrire_Form(Formateur Form) {
		Connection connexion = null; 
	     PreparedStatement preparedStatement = null; 
	        try { 
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO Formateur(nomfr,prenom,date_naissance,email,password) VALUES(?, ?, ?, ?, ?)"); 
	            preparedStatement.setString(1,Form.getNomfr()); 
	            preparedStatement.setString(2,Form.getPrenom());
	            preparedStatement.setString(3,Form.getDate_naissance());
	            preparedStatement.setString(4,Form.getEmail());
	            preparedStatement.setString(5,Form.getPassword());
	            preparedStatement.executeUpdate(); 
	        } catch (SQLException e) { 
	            e.printStackTrace();		
	}

	
	
}
	
}
