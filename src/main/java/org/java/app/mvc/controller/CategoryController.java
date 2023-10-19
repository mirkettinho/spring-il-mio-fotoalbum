package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.pojo.Category;
import org.java.app.db.serv.CategoryServ;
import org.java.app.db.serv.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryServ categoryServ;
	
	@Autowired
	private PhotoServ photoServ;
	
	@GetMapping
	public String getIndex(Model model) {
		
		List<Category> categories = categoryServ.findAll();
		model.addAttribute("categories", categories );
			
		return "categories/index";
	}
}
