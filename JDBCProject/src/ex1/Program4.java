package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Program4 {
	//jdbc 를 활용한 delete 문 사용방법
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int id = 5;
		
		String url = "jdbc:mysql://localhost:3306/notice?serverTimezone=UTC";
		String sql = "DELETE FROM NOTICE WHERE ID = ?";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","root");
		//Statement st = con.createStatement();	
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		int result = st.executeUpdate();
		System.out.println(result);
		
		st.close();
		con.close();
		
	}

}
