package com.example.baivietadmin.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.catalina.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="Posts")
public class Posts {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", columnDefinition = "VARCHAR(100) NOT NULL")
	private String name;
	@Column(name = "description", columnDefinition = "VARCHAR(400) NOT NULL")
	private String description;
	@Column(name = "content", columnDefinition = "TEXT NOT NULL")
	private String content;
	@Column(name = "datecreate", columnDefinition = "DATE NOT NULL")
	private Date datecreate;
	@Column(name = "status", columnDefinition = "TINYINT(1)")
	private int status;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private Users users;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
}
