package com.multi.animal.missingBoard;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.animal.FilterVO;
import com.multi.animal.PageVO;

@Service
public class MissingBoardServiceImpl implements MissingBoardServiceInterface {

	@Autowired
	MissingBoardDAOImpl dao;

	@Override
	public List<MissingBoardVO> list(PageVO vo) {
		return dao.list(vo);
	}

	@Override
	public int count() {
		return dao.count();
	}

	public MissingBoardVO one(MissingBoardVO vo) {
		return dao.one(vo);
	}

	public void insert(MissingBoardVO vo) {
		dao.insert(vo);
	}

	public List<MissingBoardVO> filterList(FilterVO vo) {
		return dao.filterList(vo);
	}

	public int filterCount(FilterVO vo) {
		return dao.filterCount(vo);
	}

}
