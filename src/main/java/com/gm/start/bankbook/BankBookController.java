package com.gm.start.bankbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gm.start.bankMembers.BankMembersService;

@RequestMapping(value = "/bankbook/*")
@Controller
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;

	@RequestMapping(value = "list.gm", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("리스트 Get 실행");
		ArrayList<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);

		return "bankbook/list";
	}

	@RequestMapping(value = "detail.gm", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("디테일 Get 실행");
		System.out.println(bankBookDTO.getBookNum());

		bankBookDTO = bankBookService.getDetail(bankBookDTO);

		// return "bankbook/detail";
		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankBookDTO);

		return mv;
	}

	@RequestMapping(value = "add.gm", method = RequestMethod.GET)
	public String add() {
		System.out.println("에드 Get 실행");

		return "bankbook/add";
	}

	@RequestMapping(value = "add.gm", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("에드 Post 실행");

		int result = bankBookService.setBankBook(bankBookDTO);
		System.out.println(result == 1);

		// 상품등록 후 list페이지로 이동
		ModelAndView mv = new ModelAndView();

		mv.setViewName("redirect:./list.gm");

		return mv;
	}

	@RequestMapping(value = "update.gm", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception {
		System.out.println("업데이트 Get 실행");
		System.out.println(bankBookDTO.getBookNum());

		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		// ModelAndView mv = new ModelAndView();

		model.addAttribute("dto", bankBookDTO);

		// mv.setViewName("bankbook/update");
		// mv.addObject("dto", bankBookDTO);

		// return mv;
	}

	@RequestMapping(value = "update.gm", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("업데이트 Post 실행");

		// BankBookDTO bankBookDTO = new BankBookDTO();

		int result = bankBookService.setUpdate(bankBookDTO);

		System.out.println(result == 1);

		return "redirect:./detail.gm?bookNum=" + bankBookDTO.getBookNum();

	}

	@RequestMapping(value = "delete.gm", method = RequestMethod.GET)
	public ModelAndView Delete(BankBookDTO bankBookDTO, Model model) throws Exception {
		System.out.println("딜리트 Get 실행");

		ModelAndView mv = new ModelAndView();

		int result = bankBookService.setDelete(bankBookDTO);

		mv.setViewName("redirect:./list.gm");

		System.out.println(result == 1);

		return mv;

	}

}
