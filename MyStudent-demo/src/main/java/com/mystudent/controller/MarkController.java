/**
 * 
 */
package com.mystudent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mystudent.model.Mark;
import com.mystudent.service.MarkService;

/**
 * @author Phuc Tran
 *
 */

@Controller
public class MarkController {

	private MarkService markService;
	
	@Autowired
	public MarkController(MarkService markService) {
		this.markService = markService;
	}
	
	@GetMapping("/mark/add")
	public String createMark(Model mark) {
		mark.addAttribute("mark", new Mark());
		return "form-mark";
	}
	
	//to save SUBJECT
	@PostMapping("/mark/save")
	public String saveMark(@Valid Mark mark, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "redirect:/mark/add";
		}
		
		markService.save(mark);
		return "redirect:/home";
	}

	
}
