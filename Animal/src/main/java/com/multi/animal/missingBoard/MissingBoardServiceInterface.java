package com.multi.animal.missingBoard;

import java.util.List;

import com.multi.animal.PageVO;

public interface MissingBoardServiceInterface {
	List<MissingBoardVO> list(PageVO vo);

	int count();
}