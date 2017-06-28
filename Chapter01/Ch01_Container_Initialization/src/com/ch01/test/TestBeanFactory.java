package com.ch01.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class TestBeanFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("beans_classpath.xml"));
		BeanFactory beanFactory1=new XmlBeanFactory(new FileSystemResource("d:\\beans_fileSystem.xml"));
		System.out.println("beanfactory created successfully");

	}

}













