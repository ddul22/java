package com.yedam.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //  gettersetter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든생성자
public class SearchVO {
	private int page;
	private String searchCondition;
	private String keyword;
	private int boardNo;
	
	public SearchVO(int page, String searchCondition, String keyword) {
		this.page = page;
		this.searchCondition = searchCondition;
		this.keyword = keyword; // 우클릭 소스 밑에서 3번째 클릭하면 만들어짐.
	}
	
	
	
}
