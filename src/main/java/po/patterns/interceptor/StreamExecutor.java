/*
 * File : StreamExecutor.java
 * Description : todo
 * 
 * Author :
 * Created :
 * 
 * Modified :
 * Modified by:
 * 
 * Last modification : 
 */

package po.patterns.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/rest")
public class StreamExecutor {
	
	@Inject
	private ReduceRange reduce;
	
	@GET
	//@Path("/{range}")
	@Produces(MediaType.TEXT_PLAIN)
	//public String getText(@PathParam("range") int range) {
	public String getText() {
		System.out.println("try GET");
		return "Reduce result is ";// + reduce.execute(range);
	}
	
}