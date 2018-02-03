/*
 * File : GalaxiesOfChoice.java
 * Description : check Galaxies interface
 * 
 * Author : Popov Denys
 * Created : 01 Feb, 2018
 * 
 * Modified : 01 Feb, 2018
 * Modified by: Popov Denys
 * 
 * Last modification : checkboxes interface 
 */

package po.patterns.postredirectget.galaxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.patterns.postredirectget.galaxy.db.GalaxiesData;
import po.patterns.postredirectget.galaxy.domain.Galaxy;
import po.patterns.postredirectget.galaxy.model.Pattern;
import po.patterns.postredirectget.galaxy.model.Pattern.InputType;

public class GalaxiesOfChoice extends HttpServlet {

	private static final long serialVersionUID = 2173022719737730840L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		List<Galaxy> galaxies = new GalaxiesData().getAllGalaxies();
		
		out.println("<html><body><h2>Known Galaxies</h2>");
		
		out.println("<form action=\"choosenRoute.html\" method=\"POST\">");
		
		out.println("<ul>");
		galaxies.stream().forEach(Pattern.inputGalaxyNote(out, InputType.CHECKBOX.get()));
		out.println("</ul>");
		
		out.println("<input type=\"" + InputType.SUBMIT.get() +"\" value=\"Make my choise\">");
		
		Pattern.routesFooter(out);
				
		out.println("</body></html>");
		
		out.close();
		
	}
	
}
