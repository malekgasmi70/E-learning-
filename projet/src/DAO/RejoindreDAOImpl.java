package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class RejoindreDAOImpl implements RejoindreDAO {
	private DAOFactory daoFactory; 
	RejoindreDAOImpl(DAOFactory daoFactory) { 
        this.daoFactory = daoFactory;
    }
	




	@Override
	public void ajouter(int idapp, int idform) {
		   Connection connexion = null; 
		     PreparedStatement preparedStatement = null;
			

		        try { 
		            connexion = daoFactory.getConnection();
		            preparedStatement = connexion.prepareStatement("INSERT INTO etudier VALUES(?, ?)"); 
		            preparedStatement.setInt(1,idapp);
		            preparedStatement.setInt(2,idform); 
		            preparedStatement.executeUpdate(); 
		        } catch (SQLException e) { 
		            e.printStackTrace(); 
		        }		
	}
}
