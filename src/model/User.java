package model;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String name;
	private String lastName;
	private String urlProfilePhoto = null;
	private String urlCoverPhoto = null;
	public static User currentUser = null;
	
	public User(int id) {
		this(id, null, null, null, null);
	}
	
	public User(int id, String username, String password, String name, String lastName) {
		this(id, username, password, name, lastName, null, null);
	}
	
	public User(int id, String username, String password, String name, String lastName, String urlProfilePhoto, String urlCoverPhoto) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastName = name;
		this.lastName = lastName;
		this.urlProfilePhoto = urlProfilePhoto;
		this.urlCoverPhoto = urlCoverPhoto;
	}

	public int getId() {
		return id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullname() {
		return this.name + " " + this.lastName;
	}

	public String getUrlProfilePhoto() {
		return urlProfilePhoto;
	}

	public void setUrlProfilePhoto(String urlProfilePhoto) {
		this.urlProfilePhoto = urlProfilePhoto;
	}

	public String getUrlCoverPhoto() {
		return urlCoverPhoto;
	}

	public void setUrlCoverPhoto(String urlCoverPhoto) {
		this.urlCoverPhoto = urlCoverPhoto;
	}
	
	
}
