package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Program2 {
	// jdbc를 통한 insert 문 구현 방법
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String title = "TEST2";
		String writerId = "newlec";
		String content = "hahaha";
		String files = "";
		
		String url = "jdbc:mysql://localhost:3306/notice?serverTimezone=UTC";
		String sql = "INSERT INTO NOTICE(TITLE, WRITER_ID, CONTENT, FILES) VALUES(?,?,?,?)" ;
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","root");
		//Statement st = con.createStatement();	
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		//이를 통해 values의 원하는 값을 넣을 수 있으며, 시작은 0부터가 아니라 1부터 시작한다.
		//데이터를 입력하는 방법
		int result = st.executeUpdate();
		System.out.println(result);
		
		st.close();
		con.close();
		
	}

}
