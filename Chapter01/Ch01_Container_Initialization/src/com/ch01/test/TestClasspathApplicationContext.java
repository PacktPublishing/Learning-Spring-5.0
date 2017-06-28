package com.ch01.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClasspathApplicationContext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// case1:
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"beans_classpath.xml");
			// case2

			ApplicationContext context1 = new ClassPathXmlApplicationContext(
					new String[] { "beans_classpath.xml","beans_classpath1.xml" });
			System.out.println("container created successfully");
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
