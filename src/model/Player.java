package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hayden Harris - CIS175 
 * DMACC FALL 2022
 * Oct 12, 2022
 */
@Entity
@Table(name="Player")
public class Player {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="Position")
	private String position;
	
	public Player() {
		super();
	}
	public Player(String name, String pos) {
		super();
		this.name=name;
		this.position=pos;
			
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String pos) {
		this.position=pos;
	}
	

	

	
	
}
