package com.multi.animal.missingBoard;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	
	void missingEnd(MissingBoardVO vo);
	
	List<String> fileProcess(MultipartHttpServletRequest multipartRequest, String CURR_IMAGE_REPO_PATH) throws Exception;
}