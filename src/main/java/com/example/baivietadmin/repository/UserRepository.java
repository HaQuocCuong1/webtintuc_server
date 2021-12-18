package com.example.baivietadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.baivietadmin.entity.Posts;
import com.example.baivietadmin.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}
