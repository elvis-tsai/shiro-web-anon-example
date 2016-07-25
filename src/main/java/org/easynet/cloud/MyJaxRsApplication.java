package org.easynet.cloud;

import org.restlet.Context;
import org.restlet.ext.jaxrs.JaxRsApplication;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class MyJaxRsApplication extends JaxRsApplication {

	public MyJaxRsApplication(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
	}

	@Override
	public synchronized void start() throws Exception {
		// TODO Auto-generated method stub
		super.start();
		Context context = getContext();

		Config config = ConfigFactory.load();

		Injector injector = Guice.createInjector(new ServiceModule(config));
		context.getAttributes().put("injector", injector);

		add(new MyApplication(context));
	}
}
