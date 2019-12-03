package com.practice.springboot.bean;

import org.springframework.context.annotation.Scope;

@Scope(value = "SINGLETON")
public class SingletonBean {

	private SingletonBean() {
		// As this is singleton so private method
	}
	public static String method() {
		return "method of SingletonBean class";
	}
}
