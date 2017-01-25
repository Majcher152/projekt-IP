package pierwsza_proba;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class PolaczenieZBazaDanych {
	private Connection conection = null;
 
	public static void main(String args[]) {
		new PolaczenieZBazaDanych();
	}

	public PolaczenieZBazaDanych() {
		try {
			// wczytanie sterownikow polaczenia z baza danych
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// utworzenie obiektu polaczenia
			conection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "iotrek", "iotrek");
			
		} catch (Exception e) {
		}
	}

	public boolean czyHasloPoprawne(String login, String haslo) {	
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conection.createStatement();
			resultSet = statement.executeQuery("select * from pracownik where login = '" + login +"'");
			resultSet.next();
			String hasloBaza = "";
			if (!(resultSet.isAfterLast())) {
				hasloBaza = resultSet.getString("haslo");
			}
			if (hasloBaza.equals(haslo))
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			close(resultSet);
			close(statement);
		}
	}

	public static void close(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(CallableStatement callableStatement) {
		try {
			if (callableStatement != null) {
				callableStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
