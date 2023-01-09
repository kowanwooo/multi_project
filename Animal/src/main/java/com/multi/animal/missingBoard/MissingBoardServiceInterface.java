package com.multi.animal.missingBoard;

import java.util.List;

import com.multi.animal.FilterVO;
import com.multi.animal.PageVO;

public interface MissingBoardServiceInterface {
	List<MissingBoardVO> list(PageVO vo);

	int count();
	
	MissingBoardVO one(MissingBoardVO vo);
	
	void insert(MissingBoardVO vo);
	
	List<MissingBoardVO> filterList(FilterVO vo);
	
	int filterCount(FilterVO vo);
	
	void delete(MissingBoardVO vo);
	
	void modify(MissingBoardVO vo);
}