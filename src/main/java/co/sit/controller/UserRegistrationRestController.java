package co.sit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.sit.entity.User;
import co.sit.service.UserService;

@RestController
public class UserRegistrationRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/getCountries",produces={"application/xml", "application/json"})
	public ResponseEntity<Map<Integer,String>> getCountriesMap(){
		Map<Integer, String> countries = userService.findCountries();
		return new ResponseEntity<Map<Integer,String>>(countries, HttpStatus.OK);
	}
	
	@GetMapping(value="/getStates",produces={"application/xml", "application/json"})
	public ResponseEntity<Map<Integer,String>> getStatesMap(@PathVariable("cid") Integer countryId){
		Map<Integer, String> states = userService.findStates(countryId);
		return new ResponseEntity<Map<Integer,String>>(states, HttpStatus.OK);
	}
	
	@GetMapping(value="/getCities",produces={"application/xml", "application/json"})
	public ResponseEntity<Map<Integer,String>> getCitiesMap(@PathVariable("sid") Integer stateId){
		Map<Integer, String> cities = userService.findCities(stateId);
		return new ResponseEntity<Map<Integer,String>>(cities, HttpStatus.OK);
	}
	
	@PostMapping("/registerUser")
	public @ResponseBody String registerNewUser(@RequestBody User user){	    	
		boolean userCreationStatus = userService.saveUser(user);
		if(userCreationStatus) {		
			//sending email with temporary password
			return "Please check the Email to Unlock Account";
		}
		else 
			return "Registered Email already exists";
	}		
}