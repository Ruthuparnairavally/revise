package vtiger.Pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		Driver driverrf = new Driver();
		
		//Step1: Register the driver/database
		DriverManager.registerDriver(driverrf);
		
		//Step2: get the conncetion with dabtabase
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		
		//Step3: issue create statement
		Statement state = con.createStatement();
		
		//Step4:execute a query - provide table name
		String query = "select * from clientinfo;";
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}

		//Step 5: close the database
		con.close();
	}
}
