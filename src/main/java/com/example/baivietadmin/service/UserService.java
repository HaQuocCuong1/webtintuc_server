package com.example.baivietadmin.service;

import java.util.List;

import com.example.baivietadmin.entity.Posts;
import com.example.baivietadmin.entity.Users;
import com.example.baivietadmin.model.PostDTO;
import com.example.baivietadmin.model.UserDTO;

public interface UserService {
	public List<Users> findAll();
	public Users findById(int userId);
	public void save(Users theuser);
	public void delete(int userId);
}
