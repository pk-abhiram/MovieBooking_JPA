package repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Movie;


public class MovieRepository {

	/* Create EntityManagerFactory */
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("capgdbjpa");
	
	/* Create EntityManager */
	EntityManager em = emf.createEntityManager();
	
	public void addMovie(Movie movie) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(movie);
		tx.commit();
	}
	
	public List<Movie> findMovieByName(String movieName) {	
		TypedQuery<Movie> query = em.createQuery("select m from Movie m where m.name like '%:name%'", Movie.class);
		query.setParameter("name", movieName);
		return query.getResultList();
	}
	public void updateMovie(Movie movie) {
		EntityTransaction tx = em.getTransaction();
			if(movie.getMovieId()!=0) {
			tx.begin();
			Movie updateMovie = em.find(Movie.class, movie.getMovieId());
			updateMovie.setDescription(movie.getDescription());
			updateMovie.setLanguage(movie.getLanguage());
			updateMovie.setMovieGenre(movie.getMovieGenre());
			updateMovie.setMovieHours(movie.getMovieHours());
			updateMovie.setMovieName(movie.getMovieName());
			tx.commit();
			}
		}
	public void deleteMovie(int i) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Movie movie = em.find(Movie.class, i);
		em.remove(movie);
		tx.commit();
		}
	
	public Movie findMovie(int i) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Movie movie = em.find(Movie.class, i);
		tx.commit();
		return movie;
		
	}
	public int findEqual(Movie movie) {
		TypedQuery<Movie> query = em.createQuery("select m from Movie m", Movie.class);
		for(Movie movies:query.getResultList()) {
			if(movie.equals(movies)) {
				return movie.getMovieId();
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		MovieRepository movieRepository=new MovieRepository();
		Movie movie1=new Movie("Sawshank","Crime","2:30","English","Jail");
		Movie movie2=new Movie("3 Idiots","Comedy","2:50","Hindi","College Life");
		//movieRepository.updateMovie(movie2);
	}
}
