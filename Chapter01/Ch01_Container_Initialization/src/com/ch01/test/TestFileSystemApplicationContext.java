package com.ch01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestFileSystemApplicationContext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new FileSystemXmlApplicationContext("d:\\beans_fileSystem.xml");
		//OR
    	 context=new FileSystemXmlApplicationContext("D:\\workspaces\\packt_pub\\Ch01_Container_Initialization\\src\\com\\ch01\\demos\\beans_fileSystem.xml");
		System.out.println("container created successfully");
	}

}
