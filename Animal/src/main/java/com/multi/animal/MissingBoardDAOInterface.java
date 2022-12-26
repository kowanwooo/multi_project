package com.multi.animal;

import java.util.List;

public interface MissingBoardDAOInterface {

	// 데이터 검색 기능(여러개의 docuemnt)
	public List<MissingBoardVO> list(PageVO vo);

	public int count();
}
