package dao;


	import java.util.Set;

	import entity.Customer;

	public interface CustomerDao {

		Customer findbyMobileNo(String mobileno);

		Set<Customer> allCustomers();

		

		Customer rechargeAmount(String s, double bal, double amount);

		Customer CreateAccount(String c, String n, double a);

		void addCustomer(Customer c);

	}




