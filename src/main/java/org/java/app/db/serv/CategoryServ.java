package org.java.app.db.serv;

import java.util.List;

import org.java.app.db.pojo.Category;
import org.java.app.db.pojo.Photo;
import org.java.app.db.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public void save(Category category) {
		
		categoryRepo.save(category);
	}
	
	public List<Category> findAll() {
		
		return categoryRepo.findAll();
	}
	
	public Category findById(int id) {
		
		return categoryRepo.findById(id).get();
	}
	
	public void deleteCategory(Category category) {
		
		categoryRepo.delete(category);
	}
	
	public void eliminationRelationshipPhotos(Category category) {
		
		List<Photo> photos = category.getPhotos();
		for (Photo photo : photos) {
			List<Category> categories = photo.getCategories();
			categories.remove(category);
			photo.setCategories(categories);
		}
	}
	
}
