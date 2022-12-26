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
	
	@RequestMapping("fetchBoard")
	public void list(PageVO vo, Model model) {
		if (vo.getPage() == 0) {
			vo.setPage(1);
		}
		System.out.println(vo.getPage());
		vo.setStartEnd(vo.getPage());
		List<MissingBoardVO> list = missingBoardService.list(vo);
		int count = missingBoardService.count();
		System.out.println("all count>> " + count);
		
		int pages = 0;
		if (count % 4 == 0) {
			pages = count / 4;
		}
		else {
			pages = count / 4 + 1;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pages", pages);
		System.out.println("1끝");
	}
	
}
