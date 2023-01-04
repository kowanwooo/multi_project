package com.multi.animal.missingBoard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.animal.FilterVO;
import com.multi.animal.PageVO;

@Repository
public class MissingBoardDAOImpl implements MissingBoardDAOInterface {

	@Autowired
	SqlSessionTemplate my;

	@Override
	public List<MissingBoardVO> list(PageVO vo) {
		return my.selectList("missingBoard.list", vo);
	}

	@Override
	public int count() {
		return my.selectOne("missingBoard.count");
	}

	public MissingBoardVO one(MissingBoardVO vo) {
		return my.selectOne("missingBoard.one", vo);
	}

	public void insert(MissingBoardVO vo) {
		my.insert("missingBoard.insert", vo);
	}

	public List<MissingBoardVO> filterList(FilterVO vo) {
		return my.selectList("missingBoard.filterList", vo);
	}

}
