package entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;




@Entity
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int showId;
	LocalDateTime showStartTime;
	LocalDateTime showEndTime;
	String showName;
	@OneToOne
	@JoinColumn(name="movie")
	Movie movie;
	int screenid;
	int theatreId;
	
	public Show() {
		
	}
	
	
	
	public Show(LocalDateTime showStartTime, LocalDateTime showEndTime, String showName, Movie movie, int screenid,
			int theatreId) {
		super();
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.showName = showName;
		this.movie = movie;
		this.screenid = screenid;
		this.theatreId = theatreId;
	}



	public Show(int showId, LocalDateTime showStartTime, LocalDateTime showEndTime, String showName, Movie movie,
			int screenid, int theatreId) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.showName = showName;
		this.movie = movie;
		this.screenid = screenid;
		this.theatreId = theatreId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getScreenid() {
		return screenid;
	}
	public void setScreenid(int screenid) {
		this.screenid = screenid;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", showName=" + showName + ", movie=" + movie + ", screenid=" + screenid + ", theatreId=" + theatreId
				+ "]";
	}
	
	
}
