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

### Download a free PDF

 <i>If you have already purchased a print or Kindle version of this book, you can get a DRM-free PDF version at no cost.<br>Simply click on the link to claim your free PDF.</i>
<p align="center"> <a href="https://packt.link/free-ebook/9781787120341">https://packt.link/free-ebook/9781787120341 </a> </p>