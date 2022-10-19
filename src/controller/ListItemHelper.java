package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Team;

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TaskList");

	public void insertItem(Team li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<Team> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<Team> allItems = em.createQuery("SELECT i FROM Team i").getResultList();
		return allItems;
	}

	public void deleteItem(Team toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery(
				"select li from Team li where li.name = :selectedName and li.day = :selectedDay",
				Team.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		//typedQuery.setParameter("selectedDay", toDelete.getDay());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Team result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Team searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Team found = em.find(Team.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Team toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Team> searchForItemByStore(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("select li from Team li where li.name = :selectedName", Team.class);
		typedQuery.setParameter("selectedName", name);

		List<Team> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Team> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("select li from Team li where li.day = :selectedDay", Team.class);
		typedQuery.setParameter("selectedItem", itemName);

		List<Team> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}

}
