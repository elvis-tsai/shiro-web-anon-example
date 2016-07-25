package org.easynet.cloud;

import java.util.Map.Entry;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;

import com.google.inject.AbstractModule;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigValue;

public class ServiceModule extends AbstractModule {

	private Config config;

	public ServiceModule(Config config) {
		// TODO Auto-generated constructor stub
		this.config = config;
	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

		bind(Config.class).toInstance(config);
		
		VelocityEngine velocityEngine = new VelocityEngine();
		Properties properties = new Properties();

		for (Entry<String, ConfigValue> item : config.getObject("velocity").entrySet()) {
			properties.setProperty(item.getKey().replace('_', '.').toLowerCase(),
					item.getValue().unwrapped().toString());
		}

		velocityEngine.init(properties);

		bind(VelocityEngine.class).toInstance(velocityEngine);
	}

}
