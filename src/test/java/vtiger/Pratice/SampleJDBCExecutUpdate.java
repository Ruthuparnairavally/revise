package vtiger.Pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecutUpdate {

	public static void main(String[] args) throws SQLException {

		Driver driverrf = new Driver();
		Connection con = null;
		
		try {
		
		//Step1: Register the driver/database
		DriverManager.registerDriver(driverrf);
		
		//Step2: get the conncetion with dabtabase
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb","root","root");
		
		//Step3: issue create statement
		Statement state = con.createStatement();
		
		//Step4:execute a query - provide table name
		String query = "insert into clientinfo values('satish',15,'pune');";
		int result = state.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("data inserted");
		}

		}
		finally {
			//Step 5: close the database
			con.close();
			System.out.println("database closed");
		}
		

	}

}
