package com.mystudent.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mystudent.model.Student;
import com.mystudent.service.MajorService;
import com.mystudent.service.StudentService;

@Controller
public class StudentController {
	
	private static final Set<String> GENDER = new HashSet<String>();
	
	private StudentService studentService;
	private MajorService majorService;
	
	@Autowired
	public StudentController(StudentService studentService, MajorService majorService) {
		this.studentService = studentService;
		this.majorService = majorService;
	}
	
	@RequestMapping(path= {"/", "home"})
	public String home() {
		return "home";
	}
	
	@GetMapping(path = {"/student"})
	public String getAllStudent(Model model) {
		model.addAttribute("students", studentService.getAll());
		return "list";
	}

	@GetMapping("/student/create")
	public String createStudent(Model student, Model major, Model mark, Model genderList) {
		GENDER.add("Nam");
		GENDER.add("Nữ");
		GENDER.add("Khác");
		genderList.addAttribute("genders",GENDER);
		student.addAttribute("student", new Student());
		major.addAttribute("majorsBind", majorService.getAll());
		return "form";
	}

	@PostMapping("/student/save")
	public String saveStudent(@Valid Student student, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "redirect:/student/create";
		}
		studentService.save(student);
		redirect.addFlashAttribute("success", "Saved student successfully!");
		return "redirect:/student";
	}


	@GetMapping("/student/{id}/delete")
	public String deleteStudent(@PathVariable Integer id, RedirectAttributes redirect) {
		studentService.delete(id);
		redirect.addFlashAttribute("success", "Deleted student successfully!");
		return "redirect:/student";
	}

	@GetMapping("/student/search")
	public String searchStudent(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/student";
		}

		model.addAttribute("students", studentService.search(s));
		return "list";
	}

//	@GetMapping("/student/edit-id={id}")
//	public String edit(@PathVariable Integer id, Model model, Model major) {
//		model.addAttribute("student", studentService.getOne(id));
//		major.addAttribute("majorsBind",majorService.getAll());
//		return "form-update";
//	}
	
	@GetMapping("/student/details")
	public String edit(@RequestParam Integer id, Model model) {
		model.addAttribute("student", studentService.getForMark(id));
		return "/list/details";
	}
	
}