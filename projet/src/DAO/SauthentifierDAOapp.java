package DAO;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import Beans.Apprenant;

	public class SauthentifierDAOapp {
		public boolean validate(Apprenant app) throws ClassNotFoundException {
			boolean status = false;

			Class.forName("com.mysql.jdbc.Driver");

			try  (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/notre_projet", "root", "");

					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement("select * from apprenant where email= ? and password = ? "))
			
			{ 
				preparedStatement.setString(1, app.getEmail());
				preparedStatement.setString(2, app.getPassword());

				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				status = rs.next();

			} catch (SQLException e) {
				// process sql exception
				printSQLException(e);
			}
			return status;
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
	

