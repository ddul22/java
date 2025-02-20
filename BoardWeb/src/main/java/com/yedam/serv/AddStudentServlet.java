package com.yedam.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

// service()기능구현.
@WebServlet("/addStudentServ")
public class AddStudentServlet extends HttpServlet{
	// param 의 값을 활용 -> db 입력.
		// 처리성공 / 처리실패 메세지.
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 요청정보의 한글처리.
		resp.setContentType("text/html;charset=utf-8");
		String stdNo = req.getParameter("std_no");
		String stdName = req.getParameter("std_name");
		String phone = req.getParameter("tel_no");
		String address = req.getParameter("std_addr");
		
		StudentDAO sdao = new StudentDAO();
		boolean result = sdao.addStudent(new Student (stdNo, stdName, phone, address));
		if(result) {
			resp.getWriter().print("처리성공");
		} else {
			resp.getWriter().print("처리실패");
		}
	}
}
