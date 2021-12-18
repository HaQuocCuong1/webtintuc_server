package com.example.baivietadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.baivietadmin.entity.Users;
import com.example.baivietadmin.model.UserDTO;
import com.example.baivietadmin.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Users findById(int userId) {
		// TODO Auto-generated method stub
		Optional<Users> result = userRepository.findById(userId);
		Users theUser = null;
        if (result.isPresent())
        {
        	theUser = result.get();
        }else {
            throw new RuntimeException("Did not find User id: "+userId);
        }
        return theUser;
	}

	@Override
	public void save(Users theuser) {
		// TODO Auto-generated method stub
		userRepository.save(theuser);
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
		Users theUser = findById(userId);
		if(theUser != null)
		{
			userRepository.delete(theUser);
		}
	}

}
