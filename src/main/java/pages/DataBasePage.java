package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBasePage {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String columnValue;

	public String getDataFromDB(String columnName) {
//setting properties for mySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

//           String sqlUrl = "jdbc:mysql://127.0.0.1:3306/june2022";
			String sqlUrl = "jdbc:mysql://localhost:3306/june2022";
			String sqlUsername = "root";
			String sqlPassword = "root";
			String sqlQuery = "Select * from users;";

// create connection to the local database
			connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
//           Empowering connection reference variable to execute queries
			statement = connection.createStatement();
//           Delivering query
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				columnValue = resultSet.getString(columnName);
				return columnValue;
			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (connection != null || resultSet != null) {
				try {
					connection.close();
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

		return columnValue;

	}
}
