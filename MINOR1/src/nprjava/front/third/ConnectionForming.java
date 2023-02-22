package nprjava.front.third;


import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionForming {
Connection cin=null;
public static Connection connect() {
	try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newDB","root","password");
		 JOptionPane.showMessageDialog(null, "Connection Established!");
		 return conn;
	}

	catch(Exception e){
		JOptionPane.showMessageDialog(null, e);
		return null;
		
	}
}
}

       

