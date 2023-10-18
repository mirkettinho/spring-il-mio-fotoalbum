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
@Table(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 5, max = 20, message = "min 5 caratteri e max 20")
	@Column(nullable = false)
	private String name;
	
	
	/// RELATIONS
	@ManyToMany(mappedBy = "categories")
	private List<Photo> photos = new ArrayList<>();


	///GET & SET
	public Integer getId() {
		
		return id;
	}


	public void setId(Integer id) {
		
		this.id = id;
	}


	public String getName() {
		
		return name;
	}


	public void setName(String name) {
		
		this.name = name;
	}


	public List<Photo> getPhotos() {
		
		return photos;
	}


	public void setPhotos(List<Photo> photos) {
		
		this.photos = photos;
	}
	
	
	
}
