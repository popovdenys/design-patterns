/**
 * File : Proie.java
 * Description : servlet victim
 *
 * Author : Popov Denys
 * Created : 30 Feb, 2018
 * 
 * Modified : 30 Feb, 2018
 * Modified by: Popov Denys
 * Last modification : base content
 * 
 */

package inc.pop.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Proie extends HttpServlet {

	private static final long serialVersionUID = 5577977563622883267L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("Doesn't work : <a href=\"rest/reduce/1000\">rest/reduce/1000</a>");
		out.print("<img src=\"svg/circle.svg\">");
		out.close();
		
		//super.service(request, response);
	}

}
