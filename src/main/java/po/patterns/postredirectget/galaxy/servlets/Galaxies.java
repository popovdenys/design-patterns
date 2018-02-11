/*
 * File : Galaxies.java
 * Description : welcome Galaxies' page
 * 
 * Author : Popov Denys
 * Created : 30 Jan, 2018
 * 
 * Modified : 30 Jan, 2018
 * Modified by: Popov Denys
 * 
 * Last modification : welcome list of Galaxies
 */

package po.patterns.postredirectget.galaxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.web.WebLoggerContextUtils;

import po.patterns.client.ClientApp;
import po.patterns.postredirectget.galaxy.db.GalaxiesData;
import po.patterns.postredirectget.galaxy.domain.Galaxy;
import po.patterns.postredirectget.galaxy.model.Pattern;


public class Galaxies extends HttpServlet {

	private static final long serialVersionUID = 2694378448176264111L;

	public void init() {
		System.out.println("From init");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		List<Galaxy> galaxies = new GalaxiesData().getAllGalaxies();

		out.println("<html><body><h2>Known Galaxies</h2>");
		out.println("<ul>");
		galaxies.stream().forEach(Pattern.infoListNote(out));
		out.println("</ul>");
		
		out.println();

		out.println("<a href=\"search.html\">Find your route</a> | ");
		out.println("<a href=\"choose.html\">Make your choice</a>");

		out.println("</body></html>");
		
		final Logger logger1 = LogManager.getLogger(Galaxies.class);
		
		logger1.info("Hello, servlet!");
		logger1.error("Hello, servlet!");
		logger1.fatal("Hello, servlet!");
		logger1.warn("Hello, servlet!");
		logger1.trace("Hello, servlet!");
		logger1.debug("Hello, servlet!");
		

		final AsyncContext asyncContext = request.startAsync();
		asyncContext.start(WebLoggerContextUtils.wrapExecutionContext(this.getServletContext(), () -> {
			final Logger logger = LogManager.getLogger(Galaxies.class);
			
			System.out.println(logger.getName());
			
			logger.info("Hello, servlet!");
			logger.error("Hello, servlet!");
			logger.fatal("Hello, servlet!");
			logger.warn("Hello, servlet!");
			logger.trace("Hello, servlet!");
			logger.debug("Hello, servlet!");
		}));

		out.close();

	}

}
