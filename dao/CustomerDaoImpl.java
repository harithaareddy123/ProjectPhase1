package dao;

	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.Map;
	import java.util.Set;

	import entity.Customer;
	import exceptions.CustomerNotFoundException;



	public class CustomerDaoImpl implements CustomerDao {
		private Map<String,Customer> store = new HashMap<>();
		

		@Override
		public Customer findbyMobileNo(String MobileNo) {
			Customer c=store.get(MobileNo);
			if((c.getMobileNo()=="")||(c.getMobileNo().length()>4 )){
				throw new CustomerNotFoundException("Customer not found"+MobileNo);
				
			}return c;
		}
		@Override
		public Set<Customer> allCustomers() {
			Collection<Customer> customers = store.values();
	        Set<Customer> customerSet = new HashSet<>(customers);
	        return customerSet;
		}
			

		
	
		@Override
		public Customer rechargeAmount(String s, double bal, double amount) {
			
			bal=bal+amount;
			Customer c=store.get(bal);
			return c;
		}
		@Override
		public Customer CreateAccount(String c, String n, double a) {
			Customer d=new Customer(c,n,a);
		    Customer c4=store.put(c, d);
					
			
			return c4;
		}
		@Override
		public void addCustomer(Customer c) {
			store.put(c.getMobileNo(), c);
			
		}
		

	}


