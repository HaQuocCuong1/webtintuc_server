package com.example.baivietadmin.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.baivietadmin.entity.Users;
import com.example.baivietadmin.model.UserDTO;
import com.example.baivietadmin.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
    public List<Users> findAll()
    {
        return userService.findAll();
    }
	@PostMapping("/users")
    public Users save(@RequestBody UserDTO theUser)
    {
		Users user = new Users();
		user.setId(0);
		user.setPassword(theUser.getPassword());
		user.setUsername(theUser.getUsername());
		long millis=System.currentTimeMillis();
		user.setDate(new Date(millis));
		userService.save(user);
        return user;
    }
	@PutMapping("/users")
    public Users update(@RequestBody UserDTO theUser)
    {
		Users user = new Users();
		user.setId(theUser.getId());
		user.setPassword(theUser.getPassword());
		user.setUsername(theUser.getUsername());
		long millis=System.currentTimeMillis();
		user.setDate(new Date(millis));
		userService.save(user);
        return user;
    }
	@DeleteMapping("/users/{userId}")
    public String delete(@PathVariable int userId)
    {
		userService.delete(userId);
        return "Delete success userId: "+userId;
    }
}
