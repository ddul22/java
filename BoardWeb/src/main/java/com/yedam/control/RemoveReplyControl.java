package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DataSource;
import com.yedam.dao.ReplyDAO;
import com.yedam.mapper.ReplyMapper;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글번호
		String rno = req.getParameter("rno");
		System.out.println("rno의 값:"+rno);
		// DB.
		ReplyDAO rdao = new ReplyDAO();
		ReplyMapper mapper = DataSource.getReplyMapper();
		 int run = mapper.deleteReply(Integer.parseInt(rno));
		System.out.println("삭제행수"+run);
		// json반환.
		if(run == 1) {
			// {"retCode": "OK"}
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}

	}

}
