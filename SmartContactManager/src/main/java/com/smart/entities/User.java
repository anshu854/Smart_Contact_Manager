package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int uid;
	@Column(name = "user_name")
	@NotBlank(message = "Name Required!!")
	private String name;
	@Column(unique = true,name = "user_email")
	@NotBlank(message = "Email Required!!")
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid Format!!")
	private String email;
	private String password;
	@Column(length = 500,name = "user_description")
	private String description;
	private boolean Active;
	private String Role;
	@Column(name = "user_image")
	private String Image;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private List<Contact> contacts = new ArrayList<>();
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String name, String email, String password, String description, boolean active, String role,
			String image, List<Contact> contacts) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.description = description;
		Active = active;
		Role = role;
		Image = image;
		this.contacts = contacts;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", password=" + password + ", description="
				+ description + ", Active=" + Active + ", Role=" + Role + ", Image=" + Image + ", contacts=" + contacts
				+ "]";
	}
	
}
