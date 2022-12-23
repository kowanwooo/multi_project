package com.multi.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MissingBoardController {

	@Autowired
	MissingBoardServiceImpl missingBoardService;
	
	@RequestMapping("fetchBoard.missing")
	public void list(Model model) {
		List<MissingBoardVO> list = missingBoardService.list();
		System.out.println("여러개의 documents검색 결과>> " + list);
		model.addAttribute("list", list);
	}
}
