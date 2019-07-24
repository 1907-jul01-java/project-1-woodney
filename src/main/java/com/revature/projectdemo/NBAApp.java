package com.revature.projectdemo;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/api/v1")
public class NBAApp extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(NBAController.class);
		return resources;
	}
}