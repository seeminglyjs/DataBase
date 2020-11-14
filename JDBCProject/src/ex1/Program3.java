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
	//jdbc �� Ȱ���� ������Ʈ �� �����
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
		//�̸� ���� values�� ���ϴ� ���� ���� �� ������, ������ 0���Ͱ� �ƴ϶� 1���� �����Ѵ�.
		//�����͸� �Է��ϴ� ���
		int result = st.executeUpdate();
		System.out.println(result);
		
		st.close();
		con.close();
		
	}

}
