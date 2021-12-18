package com.example.baivietadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.baivietadmin.entity.Posts;
import com.example.baivietadmin.entity.Users;
import com.example.baivietadmin.model.PostDTO;
import com.example.baivietadmin.repository.PostsRepository;
import com.example.baivietadmin.repository.UserRepository;

@Service
public class PostsServiceImpl implements PostsService{
	@Autowired
	private PostsRepository postsRepository;
	@Autowired
	private UserService userService;
	
	@Override
	public List<Posts> findAll() {
		// TODO Auto-generated method stub
		return postsRepository.findAll();
	}

	@Override
	public Posts findById(int postId) {
		// TODO Auto-generated method stub
		Optional<Posts> result = postsRepository.findById(postId);
		Posts thePosts = null;
        if (result.isPresent())
        {
        	thePosts = result.get();
        }else {
            throw new RuntimeException("Did not find User id: "+postId);
        }
        return thePosts;
	}

	@Override
	public void save(Posts thePost) {
		// TODO Auto-generated method stub
		
		postsRepository.save(thePost);
		
	}

	@Override
	public Boolean delete(int postId) {
		// TODO Auto-generated method stub
		Posts thePost = findById(postId);
		if(thePost != null)
		{
			postsRepository.delete(thePost);
			return true;
		}
		return false;
	}

	@Override
	public void updateStatusPost(int id, int type) {
		// TODO Auto-generated method stub
		postsRepository.updateStatus(id, type);
	}

}
