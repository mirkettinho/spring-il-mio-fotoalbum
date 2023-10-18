package org.java.app.db.pojo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "photos")
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 3, max = 30, message = "min 3 caratteri e max 30")
	@Column(nullable = false)
	private String title;
	
	@Size(min = 20, max = 200, message = "min 20 caratteri e max 200")
	@Column(columnDefinition = "TEXT")	///TYPE TEXT
	private String description;
	
	@Column(nullable = false)
	private String url;
	
	@Column(nullable = false)
	private boolean isVisible;
	
	
	/// RELATIONS
	@ManyToMany
	private List<Category> categories = new ArrayList<>();


	/// GET & SET
	public Integer getId() {
		
		return id;
	}


	public void setId(Integer id) {
		
		this.id = id;
	}


	public String getTitle() {
		
		return title;
	}


	public void setTitle(String title) {
		
		this.title = title;
	}


	public String getDescription() {
		
		return description;
	}


	public void setDescription(String description) {
		
		this.description = description;
	}


	public String getUrl() {
		
		return url;
	}


	public void setUrl(String url) {
		
		this.url = url;
	}


	public boolean isVisible() {
		
		return isVisible;
	}


	public void setVisible(boolean isVisible) {
		
		this.isVisible = isVisible;
	}


	public List<Category> getCategories() {
		
		return categories;
	}


	public void setCategories(List<Category> categories) {
		
		this.categories = categories;
	}
	
	
	
}