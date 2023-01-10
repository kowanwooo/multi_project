package com.multi.animal.missingBoard;

import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
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
		System.out.println(vo);
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

	@RequestMapping("missingBoard/filterPageCount")
	public void filterPageCount(FilterVO vo, Model model) {
		int filterCount = missingBoardService.filterCount(vo);
		System.out.println(vo);
		System.out.println(filterCount);
		int pages = 0;
		if (filterCount % 4 == 0) {
			pages = filterCount / 4;
		} else {
			pages = filterCount / 4 + 1;
		}
		System.out.println("all filterCount>> " + filterCount);
		model.addAttribute("count", filterCount);
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
	public String insert(MissingBoardVO vo, HttpServletRequest request,MultipartFile file) throws Exception {
		System.out.println(vo);
		String savedName = file.getOriginalFilename();
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/upload");
		System.out.println("업로드 경로는 " + uploadPath);

		System.out.println(uploadPath + "/" + savedName);
		File target = new File(uploadPath + "/" + savedName);
		if (!target.isDirectory()) {
			target.mkdir();
		}
		file.transferTo(target);
		vo.setImg(savedName);
		missingBoardService.insert(vo);
		System.out.println("BoardInsert");
		return "redirect:missingBoard.jsp";
	}

	@RequestMapping("missingBoard/searchFilter")
	public void searchFilter(FilterVO vo, Model model) {
		if (vo.getPage() == 0) {
			vo.setPage(1);
		}
		System.out.println(vo);
		System.out.println(vo.getPage());
		vo.setStartEnd(vo.getPage());
		List<MissingBoardVO> filterList = missingBoardService.filterList(vo);

		model.addAttribute("list", filterList);

		System.out.println("filterList");
	}
	
	@RequestMapping("missingBoard/delete")
	public String delete(MissingBoardVO vo)  {
		missingBoardService.delete(vo);
		return "redirect:missingBoard.jsp";
	}
	
	@RequestMapping("missingBoard/findOne")
	public void findOne(MissingBoardVO vo, Model model)  {
		MissingBoardVO one = missingBoardService.one(vo);
		model.addAttribute("one", one);
		System.out.println("findOne");
		System.out.println(one);
	}
	
	@RequestMapping("missingBoard/modify")
	public String modify(MissingBoardVO vo, HttpServletRequest request,MultipartFile file) throws Exception {
		String savedName = file.getOriginalFilename();
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/upload");
		System.out.println("업로드 경로는 " + uploadPath);

		System.out.println(uploadPath + "/" + savedName);
		File target = new File(uploadPath + "/" + savedName);
		if (!target.isDirectory()) {
			target.mkdir();
		}
		file.transferTo(target);
		vo.setImg(savedName);
		missingBoardService.modify(vo);
		System.out.println("modify");
		System.out.println(vo.getMissingId());
		System.out.println("==================");
		return "redirect:missingBoard.jsp";
	}
	
	@RequestMapping("missingBoard/missingEnd")
	public String missingEnd(MissingBoardVO vo, Model model)  {
		missingBoardService.missingEnd(vo);
		System.out.println("missingEnd");
		return "redirect:missingBoard.jsp";
	}

	
}
