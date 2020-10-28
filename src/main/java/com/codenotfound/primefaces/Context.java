package com.codenotfound.primefaces;

import org.springframework.context.ApplicationContext;

public class Context {
	private static ApplicationContext context;
	public static String username = null;
	
	

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Context.username = username;
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext context) {
		Context.context = context;
	}
	
	

}
