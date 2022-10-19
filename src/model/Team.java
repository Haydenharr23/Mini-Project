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
@Table(name="Team")
public class Team {
	@Id
	@GeneratedValue
	@Column(name="TEAM_ID")
	private int id;
	@Column(name="NAME")
	private String teamName;
	
	public Team() {
		super();
	}
	public Team(String name) {
		super();
		this.teamName=name;
		
			
	}
	
	public int getID() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getName() {
		return teamName;
	}
	public void setName(String name) {
		this.teamName=name;
	}
	
	

	

	

	
	
}
