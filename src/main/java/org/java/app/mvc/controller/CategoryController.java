package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.pojo.Category;
import org.java.app.db.serv.CategoryServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryServ categoryServ;
	
	
	@GetMapping
	public String getIndex(Model model) {
		
		List<Category> categories = categoryServ.findAll();
		model.addAttribute("categories", categories );
			
		return "categories/index";
	}
	
	
	/// CREATE
	@GetMapping("/create")
	public String create(Model model) {
		
		model.addAttribute("category", new Category());
		
		return "categories/create-edit";
	}
	
	@PostMapping("/create")
	public String storeNewCategory(@Valid @ModelAttribute Category category, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			
			return "categories/create-edit";
		}
		
		categoryServ.save(category);
		
		return "redirect:/categories";
	}
	
	
	/// DELETE
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		
		Category category = categoryServ.findById(id);
		
		categoryServ.eliminationRelationshipPhotos(category);
		categoryServ.deleteCategory(category);
		
		return "redirect:/categories";
	}
}
