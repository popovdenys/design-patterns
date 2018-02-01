package inc.pop.galaxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inc.pop.db.GalaxiesData;
import inc.pop.domain.Galaxy;
import inc.pop.galaxy.model.OutputPatterns;
import inc.pop.galaxy.model.OutputPatterns.InputType;

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
		galaxies.stream().forEach(OutputPatterns.inputGalaxyNote(out, InputType.CHECKBOX.get()));
		out.println("</ul>");
		
		out.println("<input type=\"" + InputType.SUBMIT.get() +"\" value=\"Make my choise\">");
		
		out.println("<a href=\"search.html\">Find your route</a>");
		out.println("<a href=\"choose.html\">Make your choice</a>");
				
		out.println("</body></html>");
		
		out.close();
		
	}
	
	

}
