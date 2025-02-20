package com.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * EmpDAO, StudentDAO.... 하이클래스?
 */
public class DAO {
	// connection객체. Statement, PreparedStatement, ResultSet DB로 필요한 객체라 선언?
	Connection conn = null; // 필드라 밖으로 뺌
	Statement stmt; // 쿼리실행하고 결과 반환 클래스.
	PreparedStatement psmt; // 얘도 마찬가지 파라미터넣어서 쓸수 있어 쿼리 결과를 담아놓기 위한 set컬렉션
	ResultSet rs;

	// 세션해제.
	void disConnect() {
		try {
		if(conn != null) {
				conn.close();
			}
		if (rs != null) {
			rs.close();
		}
		if(psmt != null) {
			psmt.close();
		}
		if(stmt != null) {
			stmt.close();
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 오라클 접속 세선연결.
	Connection getConnect() { // StudentDAO 도 필요해서 잘라내기해서 넣음. DAO클래스를 상속받아서 이걸 호출하면 커넥션 객체를 연결하고 반환 conn =
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클DB의 접속정보.
		String user = "hr";
		String password = "hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	} // end of getConnect().
}
