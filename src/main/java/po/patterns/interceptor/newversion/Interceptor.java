package po.patterns.interceptor.newversion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor extends HttpServlet {

	private static final long serialVersionUID = 4212374075003794943L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		new BusinessService().startService();
		
		out.println("<html><body><h2>Interceptor</h2>");
		
		out.println("</body></html>");
		
		out.close();
	}
	
}
