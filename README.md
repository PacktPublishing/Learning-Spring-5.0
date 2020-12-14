## $5 Tech Unlocked 2021!
[Buy and download this Book for only $5 on PacktPub.com](https://www.packtpub.com/product/learning-spring-5-0/9781787120341)
-----
*If you have read this book, please leave a review on [Amazon.com](https://www.amazon.com/gp/product/1787120341).     Potential readers can then use your unbiased opinion to help them make purchase decisions. Thank you. The $5 campaign         runs from __December 15th 2020__ to __January 13th 2021.__*

# Learning Spring 5.0
This is the code repository for [Learning Spring 5.0](https://www.packtpub.com/application-development/learning-spring-50?utm_source=github&utm_medium=repository&utm_content=9781787120341), published by [Packt](https://www.packtpub.com/?utm_source=github). It contains all the supporting project files necessary to work through the book from start to finish.

## About the Book
Beginning with an introduction to Spring and setting up the environment, the book will teach you in detail about the Bean life cycle and help you discover the power of wiring for dependency injection. Gradually, you will learn the core elements of Aspect-Oriented Programming and how to work with Spring MVC and then understand how to link to the database and persist data configuring ORM, using Hibernate.

## Instructions and Navigation
The code for Chapter 05 is organized into one folder, Chapter05 and the rest in one separate folder.

The code will look like the following:

```
public static void main(String[] args) {
  // TODO Auto-generated method stub
  RestTemplate template=new RestTemplate();
  Book book= template.getForObject(
    "http://localhost:8081/Ch09_Spring_Rest_JDBC/books/14", Book.class);
  System.out.println(book.getAuthor()+"\t"+book.getISBN());
}
```
 
 ## Related Products
* [Mastering Spring 5.0](https://www.packtpub.com/application-development/mastering-spring-50?utm_source=github&utm_medium=repository&utm_content=9781787123175)

* [Secure Your Spring-Based Applications](https://www.packtpub.com/application-development/secure-your-spring-based-applications-video?utm_source=github&utm_medium=repository&utm_content=9781787289123)

* [Spring: Developing Java Applications for the Enterprise](https://www.packtpub.com/web-development/spring-developing-java-applications-enterprise?utm_source=github&utm_medium=repository&utm_content=9781787127555)

