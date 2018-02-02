package inc.pop.galaxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import inc.pop.domain.Galaxy;
import inc.pop.galaxy.model.Pattern;

public class FinalizeChoice extends HttpServlet {

	private static final long serialVersionUID = -1823107474608612079L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("->doGet");
		
		HttpSession session = request.getSession();
		
		List<? super Galaxy> choosenGalaxies = (List<? super Galaxy>) session.getAttribute("choosenGalaxies");
		int[] choosenCount = {0};
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h2>Choosen Galaxies</h2>");

		out.println("<ul>");
				
		choosenGalaxies.stream().peek(g->++choosenCount[0]).forEach(Pattern.infoListNote(out));

		out.println("</ul>");

		out.print("<p><span>" + choosenCount[0] + " Galaxies in total</span></p>");

		out.println("</body></html>");

		out.close();
	}



}
