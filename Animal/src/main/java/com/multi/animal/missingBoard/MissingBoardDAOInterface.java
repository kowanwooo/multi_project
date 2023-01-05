package com.multi.animal.missingBoard;

import java.util.List;

import com.multi.animal.FilterVO;
import com.multi.animal.PageVO;

public interface MissingBoardDAOInterface {

	// 데이터 검색 기능(여러개의 docuemnt)
	public List<MissingBoardVO> list(PageVO vo);

	public int count();
	
	public MissingBoardVO one(MissingBoardVO vo);
	
	public void insert(MissingBoardVO vo);
	
	public List<MissingBoardVO> filterList(FilterVO vo);
	
	public int filterCount(FilterVO vo);
}
