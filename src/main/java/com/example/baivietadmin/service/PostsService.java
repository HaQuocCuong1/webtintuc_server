package com.example.baivietadmin.service;

import java.util.List;

import com.example.baivietadmin.entity.Posts;
import com.example.baivietadmin.model.PostDTO;

public interface PostsService {
	public List<Posts> findAll();
	public Posts findById(int postsId);
	public void save(Posts thepost);
	public Boolean delete(int postId);
	public void updateStatusPost(int id, int type);
}
