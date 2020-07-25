package model;

public class Phris {
	
	private int id;
	private User user;
	private String content;
	private String date;
	
	public Phris(int id, User user, String content, String date) {
		this.id = id;
		this.user = user;
		this.content = content;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
