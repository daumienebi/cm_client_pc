package es.daumienebi.comicmanagement.models;

import java.time.LocalDate;

/**
 * 
 * @author Daumienebi Sakpa
 * A Java class that represents each comic
 */
public class Comic {

	private Long id;
	private String name;
	private LocalDate adquisition_date;
	private String image;
	private int collection_id;
	private String state;
	private int number;
	
	public Comic() {}
	
	public Comic(Long id, String name, LocalDate adquisition_date, String image, int collection_id, String state,
			int number) {
		super();
		this.id = id;
		this.name = name;
		this.adquisition_date = adquisition_date;
		this.image = image;
		this.collection_id = collection_id;
		this.state = state;
		this.number = number;
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
	public LocalDate getAdquisition_date() {
		return adquisition_date;
	}
	public void setAdquisition_date(LocalDate adquisition_date) {
		this.adquisition_date = adquisition_date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getCollection_id() {
		return collection_id;
	}
	public void setCollection_id(int collection_id) {
		this.collection_id = collection_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Comic [id=" + id + ", name=" + name + ", adquisition_date=" + adquisition_date + ", image=" + image
				+ ", collection_id=" + collection_id + ", state=" + state + ", number=" + number + "]";
	}
}
