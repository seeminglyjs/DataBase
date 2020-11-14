package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Program3 {
	//jdbc 를 활용한 업데이트 문 사용방법
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String title = "TEST3";
		String writerId = "newlec";
		String content = "hahaha3";
		String files = "";
		int id = 4;
		
		String url = "jdbc:mysql://localhost:3306/notice?serverTimezone=UTC";
		String sql = "UPDATE notice SET TITLE = ?, CONTENT =?, FILES=? WHERE ID=?" ;
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","root");
		//Statement st = con.createStatement();	
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		//이를 통해 values의 원하는 값을 넣을 수 있으며, 시작은 0부터가 아니라 1부터 시작한다.
		//데이터를 입력하는 방법
		int result = st.executeUpdate();
		System.out.println(result);
		
		st.close();
		con.close();
		
	}

}
