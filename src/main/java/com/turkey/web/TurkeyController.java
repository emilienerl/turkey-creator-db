package com.turkey.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.turkey.business.Turkey;
import com.turkey.db.TurkeyRepo;

@CrossOrigin
@RestController
@RequestMapping("/turkeys")
public class TurkeyController {
	
	/*
	 * A controller will implement 5 CRUD methods:
	 * 1) GET ALL
	 * 2) GET BY ID
	 * 3) POST - Insert / Create
	 * 4) PUT - Update
	 * 5) DELETE - Delete
	 */
	
	@Autowired
	private TurkeyRepo turkeyRepo; 
	//instance variable for MovieRepo. Defined at the class level.
	//movieRepo is an instance variable of the MovieController class
	
	
	//get all movies
	
	@GetMapping("/")
	public List<Turkey> getAll() {
		return turkeyRepo.findAll();
	}
	
	
	//get movie by id
	
	@GetMapping("/{id}")
	public Optional<Turkey> getById(@PathVariable int id) {
		return turkeyRepo.findById(id);
	}
	

	// add a movie
	//pass instance of movie in and use JPA to add it to the database
	
	@PostMapping("/")
	public  Turkey addMovie(@RequestBody Turkey t) {
		t = turkeyRepo.save(t);
		return t;
	}
	
	
	//update a movie
	
	@PutMapping("/")
	public Turkey updateTurkey(@RequestBody Turkey t) {
		t = turkeyRepo.save(t);
		return t;
	}
	
	//delete a movie
	
	@DeleteMapping("/{id}")
	public Turkey deleteMovie(@PathVariable int id) {
		Optional<Turkey> t = turkeyRepo.findById(id);
		if (t.isPresent()) {
			turkeyRepo.deleteById(id);
		} else {
			System.out.println("Error - turkey not found for id " + id);
		}
		return t.get();
	}
	
}
