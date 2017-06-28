import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ch02.beans.Customer;
import com.ch02.beans.Customer_Constructor_DI;


public class Test_Customer_Const {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("customer.xml");
		Customer_Constructor_DI customer=(Customer_Constructor_DI)context.getBean("customer_const");
		System.out.println(customer.getCust_name()+"\t"+customer.getCust_id()+ " and your address is:-"+customer.getCust_address());
        
	}

}
