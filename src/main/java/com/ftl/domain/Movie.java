/**
 * 
 */
package com.ftl.domain;

import java.io.Serializable;

/**
 * @author kjozsa
 */
public class Movie implements Serializable, Comparable<Movie> {
	private static final long serialVersionUID = 1L;

	private String title;

	/**
	 * @param string
	 */
	public Movie(String title) {
		this.title = title;
	}

	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Movie o) {
		return title == null ? -1 : title.compareTo(o.title);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
