package com.example.demo.controller;

import com.example.demo.dao.TagRepository;
import com.example.demo.model.Tag;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.ResponseEntity.ok;

//this is the real controller
@RestController
@CrossOrigin
@RequestMapping("/api/tag/")
public class TagController1 {

	@Autowired
	TagRepository tagRepository;

	@GetMapping(path = "/allTags", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> allTags()
	{
		List<JSONObject> entities = new ArrayList<JSONObject>();
		return new ResponseEntity<Object>(tagRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path="/addTag", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addTag(@RequestBody Tag newTag) {
		tagRepository.save(newTag);

		return new ResponseEntity<Object>(tagRepository.findAll(),HttpStatus.OK);
	}


	@GetMapping(path = "getTag/{id}")
	public Tag getTagbyId(@PathVariable Long id) {
		return this.tagRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
	}

	@GetMapping(path = "getLastTag")
	public Optional<Tag> getLastTag() {
		return this.tagRepository.getLastTag().stream().findFirst();
	}
}
