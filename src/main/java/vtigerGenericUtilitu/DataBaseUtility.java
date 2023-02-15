package vtigerGenericUtilitu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * Class contains all the generic methods releted to database
 * @author RUTHUPARNA
 *
 */
public class DataBaseUtility {

	Driver driverref;
	Connection con = null;
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection connectToDb() throws SQLException
	{
		driverref = new Driver();
		DriverManager.registerDriver(driverref);
		return con = DriverManager.getConnection(IConstantUtility.DBUrl, IConstantUtility.DBUserName, IConstantUtility.DBPassword);
	}
	
	/**
	 * this method will execute query and verify the exp data in the database and
	 * return the data only if expdata and act data are matching
	 * @param query
	 * @param colIndex
	 * @param expdata
	 * @return 
	 * @throws SQLException
	 */
	public String getData(String query,int colIndex, String expdata) throws SQLException 
	{
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery(query);
		boolean flag=false;
		
		while(res.next()) {
			String actData = res.getString(colIndex);
			
			//verify exp data with act data in database
			if(actData.equals(expdata))
			{
				flag=true;  //flag raising
				break;
			}
		}
		if(flag)
		{
			System.out.println("data verifies");
			return expdata;
		}
		else
		{
			System.out.println("data not valid");
			return "";	
		}
	}
	
	public void closeToDb() throws SQLException
	{
		con.close();

	}
}
