package myclass.dal;
import java.sql.*;
import java.sql.Date;
import java.io.*;
import java.util.*;

public class dbconn {
	String driverName = null;
	String connString = null;
	String userName = null;
	String password = null;
	String propertyFileName = null;

	public Connection getDBConn() {

		this.setPropertyFileName("dbconn/dbconn.properties");
		driverName = this.getPropertyFromFile("driverName");
		connString = this.getPropertyFromFile("connString");
		userName = this.getPropertyFromFile("userName");
		password = this.getPropertyFromFile("password");
		if (driverName == null || connString == null || userName == null)
			return null;
		try {
			Connection connDBObject = null;
			Class.forName(driverName);
			connDBObject = DriverManager.getConnection(connString, userName,
					password);
			return connDBObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    public void setPropertyFileName(String propertyFileName){
    	this.propertyFileName=propertyFileName;
    }
    public String getPropertyFileName(){
    	return propertyFileName;
    }    
    public String getPropertyFromFile(String refName){
    	if(this.getPropertyFileName()==null) return new String("");
    	try{  InputStream fin=
    		     getClass().getResourceAsStream(this.getPropertyFileName());
    	      Properties props=new Properties();
    	      props.load(fin);
    	      return (String)props.getProperty(refName);    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return new String("");
    	}
    }
	public String getDriverName() {
		return driverName;
	}
	public String getConnString() {
		return connString;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {		
		return password;
	}
	
}
