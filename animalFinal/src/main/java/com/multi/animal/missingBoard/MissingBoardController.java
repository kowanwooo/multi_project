package com.multi.animal.missingBoard;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
		vo.setStartEnd(vo.getPage());
		List<MissingBoardVO> list = missingBoardService.list(vo);

		model.addAttribute("list", list);

		System.out.println("list");
	}

	@RequestMapping("missingBoard/fetchBoardNavi")
	public void listNavi(PageVO vo, Model model) {
		if (vo.getPage() == 0) {
			vo.setPage(1);
		}
		System.out.println(vo.getLocation());
		vo.setStartEnd(vo.getPage());
		System.out.println(vo.getStart());
		System.out.println(vo.getEnd());
		List<MissingBoardVO> listNavi = missingBoardService.listNavi(vo);
		System.out.println("**********" + listNavi);
		model.addAttribute("list", listNavi);

		System.out.println("listNAVI");
	}
	
	@RequestMapping("missingBoard/pageCount")
	public void pageCount(PageVO vo, Model model) {
		int count = missingBoardService.count();
		int pages = 0;
		
		if (count % 4 == 0) {
			pages = count / 4;
		} else {
			pages = count / 4 + 1;
		}
		model.addAttribute("pages", pages);
	}
	
	@RequestMapping("missingBoard/pageCountNavi")
	public void pageCountNavi(PageVO vo, Model model) {
		int count = missingBoardService.countNavi(vo);
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
		int pages = 0;
		if (filterCount % 4 == 0) {
			pages = filterCount / 4;
		} else {
			pages = filterCount / 4 + 1;
		}
		model.addAttribute("count", filterCount);
		model.addAttribute("pages", pages);
	}

	@RequestMapping("missingBoard/boardDetail")
	public void one(MissingBoardVO vo, Model model) {
		MissingBoardVO one = missingBoardService.one(vo);
		model.addAttribute("one", one);
	}

	private static final String CURR_IMAGE_REPO_PATH = 
			"C:\\Users\\user\\Documents\\workspace-sts-3.9.12.RELEASE\\animal_통합"
			+ "\\animal\\src\\main\\webapp\\resources\\upload";
	@RequestMapping("missingBoard/create")
	public String insert(MissingBoardVO vo,
			MultipartHttpServletRequest multipartRequest,
			HttpServletResponse response)
			throws Exception {
		//service영역에서  fileprocess처리
		List<String> fileList = missingBoardService.fileProcess(multipartRequest, CURR_IMAGE_REPO_PATH);

		vo.setImg1(fileList.get(0));
		vo.setImg2(fileList.get(1));
		vo.setImg3(fileList.get(2));

		missingBoardService.insert(vo);
		return "redirect:missingBoard.jsp";
	}

	@RequestMapping("missingBoard/searchFilter")
	public void searchFilter(FilterVO vo, Model model) {
		if (vo.getPage() == 0) {
			vo.setPage(1);
		}
		vo.setStartEnd(vo.getPage());
		List<MissingBoardVO> filterList = missingBoardService.filterList(vo);

		model.addAttribute("list", filterList);
		System.out.println("filterList");
	}

	@RequestMapping("missingBoard/delete")
	public String delete(MissingBoardVO vo) {
		missingBoardService.delete(vo);
		return "redirect:missingBoard.jsp";
	}

	@RequestMapping("missingBoard/findOne")
	public void findOne(MissingBoardVO vo, Model model) {
		MissingBoardVO one = missingBoardService.one(vo);
		model.addAttribute("one", one);
	}

	@RequestMapping("missingBoard/modify")
	public String modify(MissingBoardVO vo, 
			MultipartHttpServletRequest multipartRequest,
			HttpServletResponse response)
			throws Exception {
		List<String> fileList = missingBoardService.fileProcess(multipartRequest, CURR_IMAGE_REPO_PATH);
		vo.setImg1(fileList.get(0));
		vo.setImg2(fileList.get(1));
		vo.setImg3(fileList.get(2));
		missingBoardService.modify(vo);
		return "redirect:missingBoard.jsp";
	}

	@RequestMapping("missingBoard/missingEnd")
	public String missingEnd(MissingBoardVO vo, Model model) {
		missingBoardService.missingEnd(vo);
		return "redirect:missingBoard.jsp";
	}

}
