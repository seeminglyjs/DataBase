package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/notice?serverTimezone=UTC";
		String sql = "SELECT * FROM NOTICE WHERE HIT >= 10";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regDate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			//String files = rs.getString("FILES");
			
//			if(hit >= 10) {
//				System.out.printf(id+" "+title+" "+ writerId +" "+ regDate+" "+ content+" "+ hit);
//				System.out.println();	
//			} 이렇게 하면 안됨...
			
			System.out.printf(id+" "+title+" "+ writerId +" "+ regDate+" "+ content+" "+ hit);
			System.out.println();	
			
		}
		
		rs.close();
		st.close();
		con.close();

	}

}
