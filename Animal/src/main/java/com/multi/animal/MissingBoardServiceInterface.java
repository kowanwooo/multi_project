package com.multi.animal;

import java.util.List;

public interface MissingBoardServiceInterface {
	List<MissingBoardVO> list(PageVO vo);

	int count();
}