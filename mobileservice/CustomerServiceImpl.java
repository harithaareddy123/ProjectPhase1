package mobileservice;

import java.util.Set;

import dao.CustomerDao;
import entity.Customer;
import exceptions.IncorrectMobileNoException;

public class CustomerServiceImpl implements ICustomerService {

	private CustomerDao dao;

	public CustomerServiceImpl(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
	public Customer findbyMobileNo(String Mobileno) {
		if (Mobileno.length() > 4) {
			throw new IncorrectMobileNoException("Number not found" + Mobileno);
		}
		Customer c = dao.findbyMobileNo(Mobileno);
		return c;
	}

	@Override
	public Set<Customer> allCustomers() {

		Set<Customer> customers = dao.allCustomers();
		return customers;
	}

	@Override
	public Customer rechargeAmount(String s, double bal, double amount) {

		bal = bal + amount;
		System.out.println("amount has been recharged" + s + "with" + amount);
		Customer d = dao.rechargeAmount(s, bal, amount);
		System.out.println(s + " " + bal);
		return d;
	}

	@Override
	public Customer CreateAccount(String c, String n, double a) {
		Customer e = dao.CreateAccount(c, n, a);
		System.out.println("new customer has been added");
		return e;
	}

	@Override
	public void addCustomer(Customer c) {
		dao.addCustomer(c);
	}

}
