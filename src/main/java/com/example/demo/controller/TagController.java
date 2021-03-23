package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TagDao;
import com.example.demo.model.Tag;


@RestController
@RequestMapping("/Tag")
@SendTo("Topic/getTag")
public class TagController {
	
	@Autowired
	public TagDao dao ; 
    

	@GetMapping("/getTag")
	public List<Tag> getTag(){
		return (List<Tag>) dao.findAll();
	}

	@PostMapping("/addTag")
	public List saveTag(@ModelAttribute("tag")Tag tag,Model model) {
		dao.save(tag); 
		model.addAttribute("msg","Saved successfully.."); 
		List<Tag> tags = dao.findAll(); 
		model.addAttribute("tags", tags); 
		return (List<Tag>) dao.findAll(); 
		
	}

//	@GetMapping("/getLastTag")
//	public List<Tag> getLastTag(){
//		return (List<Tag>) dao.findAll().stream().min(Comparator.comparing(Tag::getId));
//	}
}
