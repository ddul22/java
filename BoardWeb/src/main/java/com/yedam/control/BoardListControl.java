package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.PageVO;
import com.yedam.common.SearchVO;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// boardList.do?searchCondition=T&keyword=123
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		sc = sc == null ? "" : sc; // null값처리.
		kw = kw == null ? "" : kw; // null값처리. 공백을 넣어 에러 안나게 함.
		
		// SearchVO : 파라미터.
		SearchVO search = new SearchVO(Integer.parseInt(page), sc, kw);
		
		String name = "홍길동";
		System.out.println(name);

		// boardList.do url 치면 -> (BoardListControl) -> boardList.jsp 전달.
		req.setAttribute("msg", name);

//		BoardDAO edao = new BoardDAO();
//		List<BoardVO> list = edao.selectBoard(search);
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		List<BoardVO> list = mapper.selectBoard(search);
		
		req.setAttribute("list", list);
		
		// 페이징.
//		int totalCnt = edao.getTotalCount(search); // 실제건수.
		int totalCnt = mapper.getTotalCount(search);
		
		PageVO paging = new PageVO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", paging);
		// searchCondition, keyword 전달.
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		// 요청재지정(url:boardList.do (boardList.jsp)) 할 때
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp); // req에 정보를 담아서 연결하고 싶은 페이지

	}
}
