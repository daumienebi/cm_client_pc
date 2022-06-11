package es.daumienebi.comicmanagement.models;

/**
 * 
 * @author Daumienebi Sakpa
 * A Java class that represents each Comic Collection
 */
public class Collection {

	private Long id;
	private String name;
	private String image;
	
	public Collection(Long id, String name, String image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
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

	@Override
	public String toString() {
		return "Collection [id=" + id + ", name=" + name + ", image=" + image + "]";
	}
	
	
	
	
	
	
}
