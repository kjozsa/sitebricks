/**
 * 
 */
package com.ftl.sitebricks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ftl.domain.Movie;
import com.ftl.domain.MovieDAO;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Get;

/**
 * @author kjozsa
 */
@At("/movies/:name")
public class MovieDetail {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	private MovieDAO movieDAO;

	private Movie movie;

	@Get
	public void get(@Named("name") String title) {
		movie = movieDAO.findByTitle(title);
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}
}
