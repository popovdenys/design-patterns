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
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.patterns.postredirectget.galaxy.db.GalaxiesData;
import po.patterns.postredirectget.galaxy.domain.Galaxy;
import po.patterns.postredirectget.galaxy.model.Pattern;


public class Galaxies extends HttpServlet {

	private static final long serialVersionUID = 2694378448176264111L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		List<Galaxy> galaxies = new GalaxiesData().getAllGalaxies();
		
		out.println("<html><body><h2>Known Galaxies</h2>");
		out.println("<ul>");
		galaxies.stream().forEach(Pattern.infoListNote(out));
		out.println("</ul>");
		
		out.println("<a href=\"search.html\">Find your route</a> | ");
		out.println("<a href=\"choose.html\">Make your choice</a>");
				
		out.println("</body></html>");
		
		out.close();
		
	}

}