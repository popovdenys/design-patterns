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

public class GalaxiesChoosen extends HttpServlet {

	private static final long serialVersionUID = 3189278280033985769L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int[] choosenCount = {0};
		
		response.setContentType("text/html");
		
		List<Galaxy> galaxies = new GalaxiesData().getAllGalaxies();
		
		out.println("<html><body><h2>Choosen Galaxies</h2>");
		
		out.println("<ul>");
		
		galaxies.parallelStream()
					.filter(g-> {
								String status = request.getParameter("galaxy-" + g.getId());
								return (status != null && status.equals("on")) ? true : false;
								})
					.peek(g->choosenCount[0]++)
					.forEach(OutputPatterns.infoListNote(out));
		
		out.println("</ul>");
		
		out.print("<p><span>" + choosenCount[0] + " Galaxies in total</span></p>");
		
		out.println("</body></html>");
		
		out.close();
	}

}
