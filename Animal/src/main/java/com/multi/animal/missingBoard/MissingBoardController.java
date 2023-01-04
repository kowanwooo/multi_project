package com.multi.animal.missingBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.animal.FilterVO;
import com.multi.animal.PageVO;

@Controller
public class MissingBoardController {

	@Autowired
	MissingBoardServiceImpl missingBoardService;

	@RequestMapping("missingBoard/fetchBoard")
	public void list(PageVO vo, Model model) {
		if (vo.getPage() == 0) {
			vo.setPage(1);
		}
		System.out.println(vo.getPage());
		vo.setStartEnd(vo.getPage());
		List<MissingBoardVO> list = missingBoardService.list(vo);

		model.addAttribute("list", list);

		System.out.println("list");
	}

	@RequestMapping("missingBoard/pageCount")
	public void pageCount(PageVO vo, Model model) {
		int count = missingBoardService.count();
		System.out.println("all count>> " + count);

		int pages = 0;
		if (count % 4 == 0) {
			pages = count / 4;
		} else {
			pages = count / 4 + 1;
		}
		model.addAttribute("count", count);
		model.addAttribute("pages", pages);
		System.out.println("pageCount");
	}

	@RequestMapping("missingBoard/boardDetail")
	public void one(MissingBoardVO vo, Model model) {
		MissingBoardVO one = missingBoardService.one(vo);
		model.addAttribute("one", one);
		System.out.println("BoardDetail");
		System.out.println(one);
	}
	
	@RequestMapping("missingBoard/create")
	public String insert(MissingBoardVO vo) {
		missingBoardService.insert(vo);
		System.out.println("BoardInsert");
		return "redirect:missingBoard.jsp";
	}
	
	@RequestMapping("missingBoard/searchFilter")
	public void searchFilter(FilterVO vo, Model model) {
		if (vo.getPage() == 0) {
			vo.setPage(1);
		}
		System.out.println(vo.getPage());
		vo.setStartEnd(vo.getPage());
		List<MissingBoardVO> filterList = missingBoardService.filterList(vo);

		model.addAttribute("list", filterList);

		System.out.println("list2");
	}
}
