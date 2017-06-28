import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ch02.stereotype.annotation.Customer_Component;


public class TestCustomer_component {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("customer.xml");
		Customer_Component customer = (Customer_Component) context.getBean("customer_Component");
		System.out.println(customer.getCust_name() + "\t" + customer.getCust_id() + 
				customer.getCust_address());

	}

}
