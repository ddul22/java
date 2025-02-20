package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 추가,수정,삭제,조회
 * Create,Read,Update,Delete
 */
public class BoardDAO extends DAO {

	// 페이징의 처리를 위한 실제데이터.
	public int getTotalCount() {
		String sql = "select count(1) from tbl_board";
		try {
			psmt = getConnect().prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1); // count(1) 값.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return 0; // 조회된 정보 없음.
	}
	
	// 글조회수 증가.
	public void updateCount(int boardNo) {
		String sql = "update tbl_board" + "   set    view_cnt = view_cnt + 1" + "   where board_no = ? ";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo);
			psmt.executeUpdate(); // 쿼리실행.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
	}

	// 상세조회. 글번호 => 전체정보 반환.
	public BoardVO getBoard(int boardNo) {
		String sql = "select board_no" //
				+ "           ,title" //
				+ "           ,content" //
				+ "           ,writer" //
				+ "           ,write_date" //
				+ "            ,view_cnt" //
				+ "     from tbl_board" //
				+ "     where board_no = ? ";

		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			// 조회결과 존재하면...
			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				// 결과반환.
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return null;
	}

	// 조회
	public List<BoardVO> selectBoard(int page) {
		List<BoardVO> BoardVO = new ArrayList<>();
		String sql = "select * "
				+ "from (select rownum rn, tbl_a.* "
				+ "      from (select board_no, title, content, writer, write_date, view_cnt  "
				+ "            from tbl_board "
				+ "            order by board_no desc) tbl_a) tbl_b "
				+ "where tbl_b.rn >= (? - 1 )* 5 + 1 "
				+ "and   tbl_b.rn <= ? * 5";
		
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, page);
			psmt.setInt(2, page);
			
			rs = psmt.executeQuery();
			// 조회결과
			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_No"));
				brd.setTitle(rs.getString("title"));
				brd.setWriter(rs.getString("writer"));
				brd.setWriteDate(rs.getDate("write_Date"));
				brd.setViewCnt(rs.getInt("view_Cnt"));
				BoardVO.add(brd);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return BoardVO;
	}

	// 추가
	public boolean insertBoard(BoardVO board) {
		String sql = "insert into tbl_board (board_no, title, content, writer)" + "values(board_seq.nextval,?,?,?)";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());

			int r = psmt.executeUpdate(); // insert 실행.
			if (r == 1) {
				return true; // 정상 등록.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return false; // 비정상 처리.
	}

	// 수정
	public boolean updateBoard(BoardVO board) {
		String sql = "update tbl_board " 
				+ "set    title = ? "
			    + "       ,content = ? "
				+ " where board_no = ? ";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());
			
			int r = psmt.executeUpdate(); // 쿼리실행.
			if(r > 0)
				return true; // 정상수정.

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return false;
	}

	// 삭제
	public boolean deleteBoard(int boardNo) {
		String query = "delete from tbl_board where board_no =?";
		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setInt(1, boardNo); // ?에 값 지정.
			int r = psmt.executeUpdate(); // 쿼리 실행.
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return false;
	} // end of deletBoard.
}
