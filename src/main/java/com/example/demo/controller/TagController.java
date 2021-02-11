package com.example.demo.controller;

import java.util.ArrayList;
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
    

	/*@PostMapping(value = "/ExistTag")
	public String ExistTag(@RequestBody List<Tag>tags) {
		dao.saveAll(tags);
		return "tag exists"; 
	}
	*/
	@GetMapping("/getTag")
	public List<Tag> getTag(){
		return (List<Tag>) dao.findAll(); 
	}
	
	@RequestMapping("/addTag")
	public List saveTag(@ModelAttribute("tag")Tag tag,Model model) {
		dao.save(tag); 
		model.addAttribute("msg","Saved successfully.."); 
		List<Tag> tags = dao.findAll(); 
		model.addAttribute("tags", tags); 
		return (List<Tag>) dao.findAll(); 
		
	}
	
	/*@RequestMapping("/getTagById")
	
	public String getTag(@RequestParam("id")int id,Model model) {
		model.addAttribute("tags",
				dao.findAll().stream().filter(u -> u.getId().equals(id)).findAny().get());
		return "Home";
		
	}*/
}
