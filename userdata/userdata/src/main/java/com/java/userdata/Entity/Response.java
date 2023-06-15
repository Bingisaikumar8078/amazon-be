package com.java.userdata.Entity;

public class Response {
	
	private Long id;
	
	private String email ;
	
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Response(Long long1, String email, String username) {
		super();
		this.id = long1;
		this.email = email;
		this.username = username;
	}

}
