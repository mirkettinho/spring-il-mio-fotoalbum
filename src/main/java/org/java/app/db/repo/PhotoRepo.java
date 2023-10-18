package org.java.app.db.repo;

import java.util.List;

import org.java.app.db.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Integer>{

	List<Photo> findByTitleContaining(String title);
}
