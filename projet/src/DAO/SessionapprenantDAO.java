package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Apprenant;

public class SessionapprenantDAO {
	public static  Apprenant Npr(String email,String password) throws ClassNotFoundException {
		Apprenant app = new Apprenant();
		Class.forName("com.mysql.jdbc.Driver");

		try  (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/notre_projet", "root", "");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select idapprenant, nom, prenom from apprenant where email=? and password=?"))
		
		{ 
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idapprenant=rs.getInt("idapprenant");
				String nom=rs.getString("nom"); 
				String prenom=rs.getString("prenom"); 
				app.setNom(nom);
				app.setPrenom(prenom);	
				app.setIdapprenant(idapprenant);
			}
		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return app;
	}

	private static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}}}

}
