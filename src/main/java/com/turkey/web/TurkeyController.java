package com.turkey.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkey.business.Turkey;


@RestController
@RequestMapping("/turkey")
public class TurkeyController {
	
	private List<Turkey> turkeys = new ArrayList<>();
	
		//gets all data ; select * - no filter
		@GetMapping("/") 
		public List<Turkey> getTurkeys() {
			return turkeys;
		}
		
		// get a single turkey by id (select *  by id)
		@GetMapping("/{id}") 
		public Turkey getTurkey(@PathVariable int id) {
			Turkey t = null;
			for (Turkey turkey: turkeys) {
				if (turkey.getId() == id) {
					t = turkey;
				}
			}
			return t;
			
		}

		
		//when we accept params we don't need a forward slash /
		@PostMapping("") 
		public Turkey createTurkey(@RequestParam int id, @RequestParam String name, @RequestParam double weight) {
			Turkey t = new Turkey(id, name, weight); //creating an instance of a turkey
			turkeys.add(t);
			return t;
			
		}
		// delete a turkey by ID (delete where id=?)
		@DeleteMapping("/{id}") 
		public Turkey deleteTurkey(@PathVariable int id) {
			Turkey t = null;
			for (Turkey turkey: turkeys) {
				if (turkey.getId() == id) {
					t = turkey;
					turkeys.remove(t);
				}
			}
			return t;
			
		}
		
		}

	


