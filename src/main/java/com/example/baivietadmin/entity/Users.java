package com.example.baivietadmin.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="Users")
public class Users {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username", columnDefinition = "VARCHAR(100) NOT NULL")
	private String username;
	@Column(name = "password", columnDefinition = "VARCHAR(100) NOT NULL")
	private String password;
	@Column(name = "date", columnDefinition = "DATETIME NOT NULL")
	private Date date;
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Posts> posts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Posts> getPosts() {
		return posts;
	}
	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}
	
}
