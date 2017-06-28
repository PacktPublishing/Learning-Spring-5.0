import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ch02.scope.annotation.Customer_Scope;


public class TestCustomer_Scope {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("customer_new.xml");
		Customer_Scope customer = (Customer_Scope) context.getBean("customer_Scope");
		System.out.println(customer.getCust_name() + "\t" + customer.getCust_id() + 
				customer.getCust_address());
		customer.setCust_name("new name set");
		
		Customer_Scope customer1 = (Customer_Scope) context.getBean("customer_Scope");
		System.out.println(customer1.getCust_name() + "\t" + customer1.getCust_id() + 
				customer1.getCust_address());
		System.out.println("after changing name and using prototype scope");
		System.out.println(customer.getCust_name() + "\t" + customer.getCust_id() + 
				customer.getCust_address());
		System.out.println(customer1.getCust_name() + "\t" + customer1.getCust_id() + 
				customer1.getCust_address());
	}

}
