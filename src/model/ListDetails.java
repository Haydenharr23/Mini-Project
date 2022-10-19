package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Hayden Harris - CIS175 
 * DMACC FALL 2022
 * Oct 18, 2022
 */

@Entity
@Table(name="ListDetails")
public class ListDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Player> listOfItems;
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param listName2
	 */
	public ListDetails(String lname) {
		this.listName=lname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	public List<Player> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<Player> listOfItems) {
		this.listOfItems = listOfItems;
	}


	/**
	 * @return
	 */
	
	
}
