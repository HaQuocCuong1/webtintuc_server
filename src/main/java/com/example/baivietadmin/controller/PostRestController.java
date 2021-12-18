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

import com.example.baivietadmin.entity.Posts;
import com.example.baivietadmin.entity.Users;
import com.example.baivietadmin.model.PostDTO;
import com.example.baivietadmin.model.UpdateStatus;
import com.example.baivietadmin.model.UserDTO;
import com.example.baivietadmin.service.PostsService;
import com.example.baivietadmin.service.UserService;

@RestController
@RequestMapping("/api")
public class PostRestController {
	 @Autowired
	 private PostsService postsService;
	 @Autowired
	 private UserService userService;
	 @GetMapping("/posts")
    public List<Posts> findAll()
    {
        return postsService.findAll();
    }
	@PostMapping("/posts")
    public Posts save(@RequestBody PostDTO thePost)
    {
		Users theUser = userService.findById(thePost.getUserId());
		Posts thePosts = null;
		if(theUser != null)
		{
			thePosts = new Posts();
			thePosts.setId(0);
			thePosts.setName(thePost.getName());
			thePosts.setDescription(thePost.getDescription());
			thePosts.setContent(thePost.getContent());
			thePosts.setStatus(0);
			long millis=System.currentTimeMillis();
			thePosts.setDatecreate(new Date(millis));
			thePosts.setUsers(theUser);
			postsService.save(thePosts);
		}
        return thePosts;
    }
	@PutMapping("/posts")
    public Posts updateStatus(@RequestBody PostDTO thePost)
    {
		Users theUser = userService.findById(thePost.getUserId());
		Posts thePosts = null;
		if(theUser != null)
		{
			thePosts = new Posts();
			thePosts.setId(0);
			thePosts.setName(thePost.getName());
			thePosts.setDescription(thePost.getDescription());
			thePosts.setContent(thePost.getContent());
			thePosts.setStatus(0);
			long millis=System.currentTimeMillis();
			thePosts.setDatecreate(new Date(millis));
			thePosts.setUsers(theUser);
			postsService.save(thePosts);
		}
        return thePosts;
    }
	@PostMapping("/posts/update-status")
    public void update(@RequestBody UpdateStatus update)
    {
		int id = update.getId();
		int type = update.getType();
		postsService.updateStatusPost(id, type);
    }
	@DeleteMapping("/posts/{postsId}")
    public String findAll(@PathVariable int postsId)
    {
        boolean check = postsService.delete(postsId);
        if(check == true)
        	return "Delete sucess posts Id "+postsId;
        else
        	return "Delete failse posts Id "+postsId;
    }
}
