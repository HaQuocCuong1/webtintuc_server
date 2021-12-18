package com.example.baivietadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.baivietadmin.entity.Posts;

@Repository
@Transactional
public interface PostsRepository extends JpaRepository<Posts, Integer>{
	@Query("UPDATE Posts p SET p.status = ?2 WHERE p.id = ?1")
    @Modifying
    public void updateStatus(int id, int type);
}
