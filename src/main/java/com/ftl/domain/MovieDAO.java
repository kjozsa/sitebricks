/**
 * 
 */
package com.ftl.domain;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import com.google.inject.Singleton;

/**
 * @author kjozsa
 */
@Singleton
public class MovieDAO {
	private Logger logger = LoggerFactory.getLogger(MovieDAO.class);
	private ObjectContainer db;
	private File dbFile;

	public MovieDAO() {
		try {
			dbFile = File.createTempFile("movies", ".db4o");
			String dbPath = dbFile.getAbsolutePath();
			logger.info("opening DB at " + dbPath);

			db = Db4o.openFile(dbPath);
			db.store(new Movie("Armageddon"));
			db.store(new Movie("Apollo 11"));

			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					db.close();
					dbFile.delete();
					logger.debug("cleaned up db");
				}
			});

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Movie> findAll() {
		Query query = db.query();
		query.constrain(Movie.class);
		query.descend("title").orderAscending();
		return query.execute();
	}

	/**
	 * @return
	 */
	public Movie findByTitle(String title) {
		ObjectSet<Object> results = db.queryByExample(new Movie(title));
		return results.size() > 0 ? (Movie) results.get(0) : null;
	}

	/**
	 * @param newMovie
	 */
	public void save(Movie newMovie) {
		logger.info("saving " + newMovie);
		db.store(newMovie);
	}
}
