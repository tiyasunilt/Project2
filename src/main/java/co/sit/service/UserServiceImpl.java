package co.sit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sit.entity.City;
import co.sit.entity.Country;
import co.sit.entity.State;
import co.sit.entity.User;
import co.sit.repository.CityRepository;
import co.sit.repository.CountryRepository;
import co.sit.repository.StateRepository;
import co.sit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Map<Integer, String> findCountries() {
		List<Country> countries = countryRepo.findAll();
		Map<Integer,String> countriesMap = new HashMap<Integer,String>();
		
		countries.forEach((country)->{
			countriesMap.put(country.getCountryId(),country.getCountryName());
		});
		
		return countriesMap;
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {
		List<State> states = stateRepo.findByCountryId(countryId);
		Map<Integer,String> statesMap = new HashMap<>();
		states.forEach((state)->{
			statesMap.put(state.getStateId(),state.getStateName());
		});
		return statesMap;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {
		List<City> cities = cityRepo.findByStateId(stateId);
		Map<Integer,String> citiesMap = new HashMap<>();
		cities.forEach((city)->{
			citiesMap.put(city.getCityId(),city.getCityName());
		}); 
		return null;
	}

	@Override
	public boolean isEmailUnique(String emailId) {
		User user = userRepo.findByEmailId(emailId);		
		return user == null;
	}

	@Override
	public boolean saveUser(User user) {
		User tempUser = userRepo.findByEmailId(user.getEmail());
		if(tempUser == null) {
			user.setIsLocked('Y');
			user.setPassword(randomPasswordGenerator());
			User insertedUser = userRepo.save(user);
			return insertedUser != null;
		}
		return false;
	}

	private String randomPasswordGenerator() {
		String pwdChars = "ABCDEFGHIJKLMNOPQRSTUVWZYXabcdefghijklmnopqrstuvwxyz0123456789!@#$%^";
		Random random = new Random();
		char[] pwd = new char[8];
		
		for(int i=0;i<8;i++) {
		  pwd[i] = pwdChars.charAt(random.nextInt(pwdChars.length()-1));	
		}
		return pwd.toString();
	}

	/**
	 * test case - 1 : Invalid UserName & Password combination ---> Expected O/P: NOT A VALID USER, PLEASE REGISTER WITH US! with Link
	 * test case - 2 : Valid userName & Password combination and Locked status == Y ---> Extected O/P: PLEASE CHECK EMAIL AND UNLOCK YOUR ACCOUNT
	 * test case - 3 : Valid userName & Password combination and Locked status == N ---> Extected O/P: WELCOME TO USER MANAGEMENT APPLICATION
    */
	@Override
	public String loginCheck(String email, String pwd) {
		User user = userRepo.findByEmailIdAndPassword(email,pwd);
		if(user != null) {
			if(user.getIsLocked()=='Y')
				return "PLEASE CHECK EMAIL AND UNLOCK YOUR ACCOUNT";
			else
				return "WELCOME TO USER MANAGEMENT APPLICATION";
		}
		
		return "NOT A VALID USER, PLEASE REGISTER WITH US! <a href=#>Register Here</a>";
	}

	/**
	 * testcase-1 : User Input is Invalid Temp Passord: Expected O/P : false;
	 * testcase-2 : User Input is Valid temp Password: Expected O/P: true  
	 */
	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		User user = userRepo.findByEmailIdAndPassword(email,tempPwd);
		return user != null;
	}

	@Override
	public boolean unlockAccount(String email, String newPwd) {
		User user = userRepo.findByEmailId(email);
		if(user != null) {
			if(user.getIsLocked()=='Y') {
				user.setPassword(newPwd);;
				user.setIsLocked('N');
				return true;
			}
		}
		return false;
	}

	@Override
	public String forgotPassword(String email) {
		User user = userRepo.findByEmailId(email);
		if(user != null)
			return user.getPassword();
		return null;
	}


}
