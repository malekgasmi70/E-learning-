package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Formateur;



public class SessionformateurDAO {
	public Formateur Npr(String email,String password) throws ClassNotFoundException {
		Formateur Form = new Formateur();
		Class.forName("com.mysql.jdbc.Driver");

		try  (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/notre_projet", "root", "");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select idformateur, nomfr,prenom from Formateur where email=? and password=?"))
		
		{ 
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idformateur=rs.getInt("idformateur");
				String nomfr=rs.getString("nomfr"); 
				String prenom=rs.getString("prenom"); 
				Form.setNomfr(nomfr);
				Form.setPrenom(prenom);	
				Form.setIdformateur(idformateur);
			}
		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return Form;
	}

	private void printSQLException(SQLException ex) {
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
			}}}}






