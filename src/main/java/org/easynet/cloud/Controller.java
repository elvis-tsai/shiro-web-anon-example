package org.easynet.cloud;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.app.VelocityEngine;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.ext.servlet.ServletUtils;
import org.restlet.representation.Representation;
import org.restlet.resource.ServerResource;

import com.google.inject.Injector;
import com.typesafe.config.Config;

public class Controller extends ServerResource {

	protected Injector injector = (Injector) this.getApplication().getContext().getAttributes().get("injector");

	/**
	 * ≈‰÷√Œƒº˛
	 */
	protected Config applicationConfig = injector.getInstance(Config.class);

	/**
	 * Servlet Request
	 */
	protected HttpServletRequest httpServletRequest = ServletUtils.getRequest(Request.getCurrent());

	/**
	 * Servlet Response
	 */
	protected HttpServletResponse httpServletResponse = ServletUtils.getResponse(Response.getCurrent());

	protected VelocityEngine velocityEngine = injector.getInstance(VelocityEngine.class);

	protected Representation render(String view, Map<String, Object> viewData, MediaType mediaType) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("httpRequest", httpServletRequest);
		data.put("config", applicationConfig);
		viewData.putAll(data);

		return new VelocityRepresentation(view, viewData, velocityEngine, mediaType);
	};

}
