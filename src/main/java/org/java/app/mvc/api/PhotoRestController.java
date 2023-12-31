package org.java.app.mvc.api;

import java.util.List;

import org.java.app.db.pojo.Photo;
import org.java.app.db.serv.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/photos")
public class PhotoRestController {

	@Autowired
	private PhotoServ photoServ;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Photo>> getAllOrByTitle(@RequestParam(required = false, name = "q") String query) {
		
		List<Photo> photo = query == null ? photoServ.findAll() : photoServ.findByTitle(query);
		
		return new ResponseEntity<>(photo, HttpStatus.OK);
	}
}
