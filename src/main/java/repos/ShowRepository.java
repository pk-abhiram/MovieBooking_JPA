package repos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Show;

public class ShowRepository {

	/* Create EntityManagerFactory */
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("capgdbjpa");
	
	/* Create EntityManager */
	EntityManager em = emf.createEntityManager();
	
	public void addShow(Show show) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(show);
		tx.commit();
	}
	
	public List<Show> findShowByName(String showName) {	
		TypedQuery<Show> query = em.createQuery("select s from Show s where s.name like '%:name%'", Show.class);
		query.setParameter("name", showName);
		return query.getResultList();
	}
	public void updateShow(Show show) {
		EntityTransaction tx = em.getTransaction();
			if(show.getShowId()!=0) {
			tx.begin();
			Show updateShow=em.find(Show.class, show.getShowId());
			if(!show.getMovie().equals(null))
			updateShow.setMovie(show.getMovie());
			if(show.getScreenid()!=0)
			updateShow.setScreenid(show.getScreenid());
			if(show.getShowEndTime()!=null)
			updateShow.setShowEndTime(show.getShowEndTime());
			if(!show.getShowName().equals(null))
			updateShow.setShowName(show.getShowName());
			if(show.getShowStartTime()!=null)
			updateShow.setShowStartTime(show.getShowStartTime());
			if(show.getTheatreId()!=0)
			updateShow.setTheatreId(show.getTheatreId());
			tx.commit();
			}
		}
	public void removeShow(Show show) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Show removeShow = em.find(Show.class, show.getShowId());
		em.remove(removeShow);
		tx.commit();
		}
	
	public Show findShow(int i) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Show show = em.find(Show.class, i);
		tx.commit();
		return show;
		
	}
	public List<Show> viewShowList(int theatreid){
		TypedQuery<Show> query = em.createQuery("select s from Show s where s.theatreId=:theatreId", Show.class);
		query.setParameter("theatreId", theatreid);
		return query.getResultList();
	}
	
	public List<Show> viewShowList(LocalDate date){
	
		List<Show>shows=viewAllShows();
		List<Show>showDate=new ArrayList<Show>();
		
		for(Show show:shows) {
			if(show.getShowStartTime().toLocalDate().isEqual(date)) {
				showDate.add(show);
			}
		}
		return showDate;
	}
	public List<Show> viewAllShows(){
		TypedQuery<Show> query = em.createQuery("select s from Show s",Show.class);
		return query.getResultList();
	}
	public static void main(String[] args) {
		ShowRepository showRepository=new ShowRepository();
		Show show2=new Show(LocalDateTime.now(), LocalDateTime.now(), "screen2", null, 0, 0);
		//showRepository.addShow(show2);
		LocalDate date=LocalDate.now();
		System.out.println(showRepository.viewShowList(date));
		
	}
}

