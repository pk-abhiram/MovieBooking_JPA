package repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Screen;

public class ScreenRepository {
	/* Create EntityManagerFactory */
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("capgdbjpa");
	
	/* Create EntityManager */
	EntityManager em = emf.createEntityManager();
	
	public void addScreen(Screen screen) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(screen);
		tx.commit();
	}
	
	public List<Screen> findScreenByName(String screenName) {	
		TypedQuery<Screen> query = em.createQuery("select s from Screen s where s.name like '%:name%'", Screen.class);
		query.setParameter("name", screenName);
		return query.getResultList();
	}
	public void updateScreen(Screen screen) {
		EntityTransaction tx = em.getTransaction();
			if(screen.getScreenId()!=0) {
			tx.begin();
			
			tx.commit();
			}
		}
	public void deleteScreen(int i) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Screen screen = em.find(Screen.class, i);
		em.remove(screen);
		tx.commit();
		}
	
	public Screen findScreen(int i) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Screen screen = em.find(Screen.class, i);
		tx.commit();
		return screen;
		
	}
	public void UpdateScreen(Screen screen) {
		if(screen.getScreenId()!=0) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();	
			Screen updateScreen = em.find(Screen.class, screen.getScreenId());
			updateScreen.setColumns(screen.getColumns());
			updateScreen.setRows(screen.getRows());
			updateScreen.setScreenName(screen.getScreenName());
			updateScreen.setShowList(screen.getShowList());
			updateScreen.setTheatreId(screen.getTheatreId());
			tx.commit();
		}
	}
}
