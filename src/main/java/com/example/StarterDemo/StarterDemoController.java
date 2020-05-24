package com.example.StarterDemo;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class StarterDemoController {
	
	@Autowired
	private SpringCrudRepository sprp;
	@Autowired
	private ManagerRepository mrp;
	
	@RequestMapping("/isup")
	public String Welcome() {
		return "Application is up and running !!!";		
	}
	
	@RequestMapping("/getRecords")
		public Iterable<Employee> allData(){
		return(Iterable<Employee>) sprp.findAll();
	}
	
	@DeleteMapping("/DeleteRecords/{empid}")
	public void delete(@PathVariable int empid) {
		System.out.println("value of age"+empid);
		sprp.deleteById(empid);
	}
	
	@PostMapping("/employee")
	@ResponseBody
	public void post(@RequestBody Employee er) {
		sprp.save(er);
	}
	
	@PostMapping("/manager")
	@ResponseBody
	public void postmanager(@RequestBody Manager mr) {
	    //code
		try {
			mrp.save(mr);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@GetMapping(path = "/{firstname}/{password}")
	public Manager postUser(@PathVariable String firstname, @PathVariable String password)
	{		
	 return mrp.findByName(firstname, password);
	}
	
	@GetMapping(path = "/{empid}")
	public Optional<Employee> findUser(@PathVariable int empid)
	{	
		System.out.println(empid);
	 return sprp.findById(empid);
	}
	
}
