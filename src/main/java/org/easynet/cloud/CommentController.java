package org.easynet.cloud;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;

@Path("comment")
public class CommentController extends Controller {

	@GET
	@Path("")
	@Produces("text/html")
	public Representation index() {
		Map<String, Object> viewData = new HashMap<String, Object>();
		return render("comment/index", viewData, MediaType.TEXT_HTML);
	}

	@POST
	@Path("add")
	@Produces("application/json")
	public String addComment(@QueryParam("randnum") String randnum, @FormParam("remark") String remark) {
		return "{\"randnum\":\"" + randnum + "\",\"remark\":\"" + remark + "\"}";
	}
}
