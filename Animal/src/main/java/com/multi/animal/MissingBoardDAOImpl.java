package com.multi.animal;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MissingBoardDAOImpl implements MissingBoardDAOInterface {
	
	@Autowired
	SqlSessionTemplate my;
	
	@Override
	public List<MissingBoardVO> list() {
		return my.selectList("missingBoard.list");
	}

}
