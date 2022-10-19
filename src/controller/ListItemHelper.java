package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;
import model.Team;

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mini-project");

	public void insertItem(Player li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<Player> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<Player> allItems = em.createQuery("SELECT i FROM Player i").getResultList();
		return allItems;
	}

	public void deleteItem(Player toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery(
				"select li from Player li where li.name = :selectedName and li.position = :selectedPosition",
				Player.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedPosition", toDelete.getPosition());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Player result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Player searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player found = em.find(Player.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Player toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Player> searchForItemByStore(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select li from Player li where li.name = :selectedName", Player.class);
		typedQuery.setParameter("selectedName", name);

		List<Player> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Player> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select li from Player li where li.position = :selectedPosition", Player.class);
		typedQuery.setParameter("selectedItem", itemName);

		List<Player> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}

}
