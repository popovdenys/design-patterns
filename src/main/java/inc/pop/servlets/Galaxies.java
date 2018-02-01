package inc.pop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inc.pop.db.GalaxiesData;
import inc.pop.domain.Galaxy;


public class Galaxies extends HttpServlet {

	private static final long serialVersionUID = 2694378448176264111L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		List<Galaxy> galaxies = new GalaxiesData().getAllGalaxies();
		
		out.println("<html><body><h1>Known Galaxies<h1>");
		out.println("<ul>");
		Stream.of(galaxies).forEach(g -> out.println("<li>" + g + "</li>"));
		out.println("</ul></body></html>");
		
		out.close();
		
	}
	
	

}
