package org.easynet.cloud;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.restlet.data.MediaType;
import org.restlet.representation.WriterRepresentation;

public class VelocityRepresentation extends WriterRepresentation {

	private Map<String, Object> viewData;
	private VelocityEngine velocityEngine;
	private String view;

	public VelocityRepresentation(String view, Map<String, Object> viewData, VelocityEngine velocityEngine,
			MediaType mediaType) {
		super(mediaType);
		// TODO Auto-generated constructor stub
		this.viewData = viewData;
		this.velocityEngine = velocityEngine;
		this.view = view;
	}

	@Override
	public void write(Writer writer) throws IOException {
		// TODO Auto-generated method stub

		VelocityContext context = new VelocityContext();
		for (String key : viewData.keySet()) {
			context.put(key, viewData.get(key));
		}
		String tplView = "";
		if (view.startsWith("/"))
			tplView = view.substring(1);
		else
			tplView = view;

		tplView += ".html";

		velocityEngine.getTemplate(tplView).merge(context, writer);

	}

}
