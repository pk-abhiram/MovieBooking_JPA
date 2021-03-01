package repos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Movie;
import entities.Screen;
import entities.Show;
import entities.Theatre;

public class TheatreRepository {

	/* Create EntityManagerFactory */
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("capgdbjpa");
	
	/* Create EntityManager */
	EntityManager em = emf.createEntityManager();
	
	public void addTheatre(Theatre theatre) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(theatre);
		tx.commit();
	}
	
	public List<Theatre> findTheatreByName(String theatreName) {	
		TypedQuery<Theatre> query = em.createQuery("select t from Theatre t where t.theatreName LIKE :vari ", Theatre.class);
		query.setParameter("vari", "%"+theatreName+"%");
		return query.getResultList();
	}
	
	public void deleteTheatre(int i) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Theatre theatre = em.find(Theatre.class, i);
		em.remove(theatre);
		tx.commit();
		}
	
	public Theatre findTheatre(int i) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Theatre theatre = em.find(Theatre.class, i);
		tx.commit();
		return theatre;
		
	}
	public void update(Theatre theatre) {
		if(theatre.getTheatreId()!=0) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();	
			Theatre updateTheatre = em.find(Theatre.class, theatre.getTheatreId());
			updateTheatre.setListOfMovies(theatre.getListOfMovies());
			updateTheatre.setListOfScreens(theatre.getListOfScreens());
			updateTheatre.setManagerContact(theatre.getManagerContact());
			updateTheatre.setManagerName(theatre.getManagerName());
			updateTheatre.setTheatreCity(theatre.getTheatreCity());
			updateTheatre.setTheatreName(theatre.getTheatreName());
			tx.commit();
		}
	}
	
	public static void main(String[] args) {
//		TheatreRepository theatreRepository=new TheatreRepository();
//		Movie movie1=new Movie("Sawshank","Crime","2:30","English","Jail");
//		Movie movie2=new Movie("2 Idiots","Comedy","2:40","Hindi","College");
//		Show show=new Show(null, null, "Second Show", movie1, 1, 1);
//		//Screen screen1=new Screen(1, "Screen1",null, 10, 10);
//		List<Movie>movie = new ArrayList<Movie>();
//		List<Screen>screen=new ArrayList<Screen>();
//		movie.add(movie1);
//		
//		Theatre theatre1=new Theatre("Cauvery","Bangalore",null,null,"Ravi","974092");
//		//movie.add(movie2);
//		Theatre theatre2=new Theatre("RMZ","Bangalore",null,null,"Abhi","984091");
//		theatreRepository.addTheatre(theatre1);
//		theatreRepository.addTheatre(theatre2);
//		
//		
//		Theatre theatre2=new Theatre("2 Idiots","Comedy","2:40","Hindi","College");
//		theatreRepository.addTheatre(theatre2);
//		List<Theatre>findTheatre=theatreRepository.findTheatreByName("ver");
//		System.out.println(findTheatre);
	}
}

