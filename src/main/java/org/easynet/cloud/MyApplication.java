package org.easynet.cloud;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.restlet.Context;

public class MyApplication extends Application{

	public MyApplication(Context context) {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		Set<Class<?>> cls=new HashSet<Class<?>>();
		
		cls.add(CommentController.class);
		
		return cls;
	}
}
