package com.smart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	private int cid;
	@Column(name = "contact_firstname")
	private String name;
	@Column(name = "contact_email")
	private String email;
	private String image;
	private String work;
	private String nickname;
	@Column(name = "contact_description",length = 5000)
	private String about;
	private long phonenumber;
	@ManyToOne
	private User user;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Contact(int cid, String name, String email, String image, String work, String nickname, String about,
			long phonenumber, User user) {
		super();
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.image = image;
		this.work = work;
		this.nickname = nickname;
		this.about = about;
		this.phonenumber = phonenumber;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", name=" + name + ", email=" + email + ", image=" + image + ", work=" + work
				+ ", nickname=" + nickname + ", about=" + about + ", phonenumber=" + phonenumber + ", user=" + user
				+ "]";
	}
	
}
