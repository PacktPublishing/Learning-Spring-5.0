package com.packt.ch04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.packt.ch03.dao.BookDAO_new;

@Aspect
public class MyIntroductionAspect {
	
	@DeclareParents(value="com.packt.ch03.dao.BookDAO+", defaultImpl=com.packt.ch03.dao.BookDAO_new_Impl.class)
	BookDAO_new bookDAO_new;

}
