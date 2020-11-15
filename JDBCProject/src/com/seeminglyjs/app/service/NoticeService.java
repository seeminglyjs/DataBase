package com.seeminglyjs.app.service;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seeminglyjs.app.entity.Notice;

public class NoticeService {
	private String url = "jdbc:mysql://localhost:3306/notice?serverTimezone=UTC";
	private String uid = "root";
	private String upw = "root";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	public List<Notice> getList(int page) throws ClassNotFoundException, SQLException{
		int end = 10 * page;
		
		String sql = "select @rownum:=@rownum+1 as rownum, dic.* from notice dic, (select @rownum :=0)tmp order by regdate desc limit ?";
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,upw);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, end);
		ResultSet rs = st.executeQuery();
		
		List <Notice> list = new ArrayList<Notice>();
		
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");
			
			Notice notice = new Notice( id, title, writerId, regDate, content, hit, files);
			
			list.add(notice);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	//scalar
		public int getCount() throws ClassNotFoundException, SQLException {
			int count = 0;
			String sql = " select count(ID) as COUNT from NOTICE";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,uid,upw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
				count = rs.getInt("COUNT");

			
			rs.close();
			st.close();
			con.close();
			
			return count;
		}
	
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		String sql = "INSERT INTO NOTICE(TITLE, WRITER_ID, CONTENT, FILES) VALUES(?,?,?,?)" ;
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,upw);
		//Statement st = con.createStatement();	
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		//이를 통해 values의 원하는 값을 넣을 수 있으며, 시작은 0부터가 아니라 1부터 시작한다.
		//데이터를 입력하는 방법
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		String sql = "UPDATE notice SET TITLE = ?, CONTENT =?, FILES=? WHERE ID=?" ;
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,upw);
		//Statement st = con.createStatement();	
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		//이를 통해 values의 원하는 값을 넣을 수 있으며, 시작은 0부터가 아니라 1부터 시작한다.
		//데이터를 입력하는 방법
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return  result ;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM NOTICE WHERE ID = ?";
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,upw);
		//Statement st = con.createStatement();	
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		int result = st.executeUpdate();
			
		st.close();
		con.close();
		return  result;
	}
	
	
}
