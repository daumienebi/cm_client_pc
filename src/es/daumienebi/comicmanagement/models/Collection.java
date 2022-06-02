package es.daumienebi.comicmanagement.models;

/**
 * 
 * @author Daumienebi Sakpa
 * A Java class that represents each collection
 */
public class Collection {

	private Long id;
	private String name;
	private String image;
	
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Collection [id=" + id + ", name=" + name + ", image=" + image + "]";
	}
	
	
	
	
}
