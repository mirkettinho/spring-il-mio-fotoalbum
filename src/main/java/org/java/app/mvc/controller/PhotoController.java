package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.pojo.Photo;
import org.java.app.db.serv.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class PhotoController {
	
	@Autowired
	private PhotoServ photoServ;
	
	@GetMapping("/")
	public String getIndex(@RequestParam(required = false) String searchInput, Model model) {
		
		
		List<Photo> photos = searchInput == null ? photoServ.findAll() : photoServ.findByTitle(searchInput);
		model.addAttribute("photos", photos);
		model.addAttribute("searchInput", searchInput);
		
		return "photos/index";
	}
	
	/// DETAILS
	@GetMapping("/photos/{id}")
	public String getShow(@PathVariable Integer id, Model model) {
		
		Photo photo = photoServ.findById(id);
		model.addAttribute("photo", photo);
		
		return "photos/show";
		
	}
	
	/// CREATE
	@GetMapping("photos/create")
	public String create(Model model) {
		model.addAttribute("photo", new Photo());
		
		return "photos/create-edit";
	}
	
	@PostMapping("photos/create")
	public String storeNewPhoto(@Valid @ModelAttribute("photo") Photo photo, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			return "photos/create-edit";
		}
		
		System.out.println("photo:\n " + photo);
		
		
		photoServ.save(photo);
		
		return "redirect:/";
	}
	
	
	/// EDIT
	@GetMapping("/photos/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		
		Photo photo = photoServ.findById(id);
		model.addAttribute("photo", photo);
		
		return "photos/create-edit";
	}
	
	@PostMapping("/photos/edit/{id}")
	public String updatePhoto(@Valid @ModelAttribute Photo photo,
			BindingResult bindingResult,
			Model model) {
		
		return savePhoto(photo, bindingResult, model);
	}
	
	
	/// DELETE
	@PostMapping("/photos/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Photo photo = photoServ.findById(id);
		
		
	    
		photoServ.deletePhoto(photo);
		
		return "redirect:/";
	}
	
	
	/// DELETE ALL PHOTO
	@PostMapping("/photos/deleteAll")
	public String deleteAllPhotos() {
		
		photoServ.deleteAllPhotos();
		
		return "redirect:/";
	}
	
	
	/// CONFIRM DELETE
	@GetMapping("/photos/confirm-delete-all")
	public String showDeleteAllConfirmation(Model model) {
		
	    return "photos/confirm-delete-all";
	}
	
	
	
	private String savePhoto(Photo photo, BindingResult bindingResult, Model model) {
		
		photoServ.save(photo);
		return "redirect:/";
		
	}
}
