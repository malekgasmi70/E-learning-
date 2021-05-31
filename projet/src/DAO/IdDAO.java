package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Formateur;


public class IdDAO {
	public Formateur idcheker(String nomformateur) throws ClassNotFoundException {
		Formateur Form = new Formateur();
		int id = -1;

		Class.forName("com.mysql.jdbc.Driver");

		try  (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/notre_projet", "root", "");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select idformateur from formateur where nomfr=?"))
		
		{ 
			preparedStatement.setString(1, nomformateur);
			
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				id = rs.getInt("idformation"); 	
			}
		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		Form.setIdformateur(id);
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
			}}}

}