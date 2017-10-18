package com.unj.dubbotest.provider;

import java.util.List;

public interface DemoService {

	String sayHello(String name);

	@SuppressWarnings("rawtypes")
	public List getUsers();

}