/**
 * 
 */
package com.ftl.sitebricks;

import java.util.Date;

import com.google.sitebricks.At;

/**
 * @author kjozsa
 */
@At("/")
public class Example {
	private boolean appear;

	public String getTime() {
		return new Date().toString();
	}

	/**
	 * @return the appear
	 */
	public boolean isAppear() {
		return appear;
	}

	/**
	 * @param appear
	 *            the appear to set
	 */
	public void setAppear(boolean appear) {
		this.appear = appear;
	}
}
