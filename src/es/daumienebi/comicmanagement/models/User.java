package es.daumienebi.comicmanagement.models;

public class User {
	private Long id;
	private String name;
	private String email;
	private int telefono;
	
	public User() {
		
	}
	
	public User(Long id, String name, String email,int telefono) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefono = telefono;
	}
	
	public User(String name, String email) {
		
		this.id = (long) 0;
		this.name = name;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public int getTelefono() {
		return this.telefono;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", telefono=" + telefono + "]";
	}
	
	
}

