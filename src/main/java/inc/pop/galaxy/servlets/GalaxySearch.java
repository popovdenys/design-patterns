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

public class GalaxySearch extends HttpServlet {

	private static final long serialVersionUID = 4300872895946022649L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get method");
		getSearchResult(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post method");
		getSearchResult(request, response);
	}



	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service method");
		doPost(request, response);
		doGet(request, response);
	}

	private void getSearchResult(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		System.out.println("from method getSearchResult");
		
		String searchCriteria = request.getParameter("searchCriteria");
		List<Galaxy> foundGalaxies = new GalaxiesData().find(searchCriteria);
		
		out.println("<html><body><h3>Found route</h3>");
		out.println("<ul>");
		
		if (foundGalaxies.size() > 0) foundGalaxies.stream().forEach(OutputPatterns.infoListNote(out));
		else out.println("Your route hasn't been found yet.");
		
		out.println("</ul></body></html>");
		out.close();
	}
	
	

}
