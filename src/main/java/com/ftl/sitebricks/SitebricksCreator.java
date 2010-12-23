/**
 * 
 */
package com.ftl.sitebricks;

import com.ftl.domain.MovieDAO;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;

/**
 * @author kjozsa
 */
public class SitebricksCreator extends GuiceServletContextListener {

	/**
	 * @see com.google.inject.servlet.GuiceServletContextListener#getInjector()
	 */
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new SitebricksModule() {
			@Override
			protected void configureSitebricks() {
				scan(Example.class.getPackage());
				scan(MovieDAO.class.getPackage());
			}
		});
	}
}
