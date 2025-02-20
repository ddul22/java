package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.PageVO;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// boardList.do?page=1
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		
		String name = "홍길동";
		System.out.println(name);

		// boardList.do url 치면 -> (BoardListControl) -> boardList.jsp 전달.
		req.setAttribute("msg", name);

		BoardDAO edao = new BoardDAO();
		List<BoardVO> list = edao.selectBoard(Integer.parseInt(page));
		req.setAttribute("list", list);
		
		// 페이징.
		int totalCnt = edao.getTotalCount(); // 실제건수.
		PageVO paging = new PageVO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", paging);
		
		// 요청재지정(url:boardList.do (boardList.jsp)) 할 때
		req.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(req, resp); // req에 정보를 담아서 연결하고 싶은 페이지

	}
}
