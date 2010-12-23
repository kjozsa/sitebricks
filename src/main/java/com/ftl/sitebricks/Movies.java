/**
 * 
 */
package com.ftl.sitebricks;

import java.util.List;

import com.ftl.domain.Movie;
import com.ftl.domain.MovieDAO;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Post;

/**
 * @author kjozsa
 */
@At("/movies")
public class Movies {
	@Inject
	private MovieDAO movieDAO;

	private Movie newMovie = new Movie(null);

	@Post
	public String save() {
		movieDAO.save(newMovie);
		return "/movies";
	}

	public List<Movie> getMovies() {
		return movieDAO.findAll();
	}

	/**
	 * @return the newMovie
	 */
	public Movie getNewMovie() {
		return newMovie;
	}
}
