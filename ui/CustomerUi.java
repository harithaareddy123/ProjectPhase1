package ui;

	import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

	import dao.CustomerDaoImpl;
	import entity.Customer;
	import mobileservice.CustomerServiceImpl;
	import mobileservice.ICustomerService;

	public class CustomerUi {
	private ICustomerService service=new CustomerServiceImpl(new CustomerDaoImpl());

	public static void main(String[] args) {
	    CustomerUi ui = new CustomerUi();
	    ui.runUi();
	}

	private void runUi() {
		try {
			System.out.println("MENU");
			System.out.println("2.Recharge Account");
			System.out.println("1.Check Balance");
			System.out.println("3.Create Account");
			System.out.println("4.Exit");
			
			Customer c1=new Customer("9876","haritha",40);
			Customer c2=new Customer("7684","ruchika",60);
			Customer c3=new Customer("7683","samrath",80);
			service.addCustomer(c1);
			service.addCustomer(c2);
			service.addCustomer(c3);
			Customer fetched1=service.findbyMobileNo("9876");
			Customer fetched2=service.findbyMobileNo("7684");
			Customer fetched3=service.findbyMobileNo("7683");
			//System.out.println(fetched1.getBalance());
			//System.out.println(fetched2.getBalance());
			//System.out.println(fetched3.getBalance());
			System.out.println("Select an option");
			Set<Customer> customers= service.allCustomers();
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
				case 1: //account balance enquiry
					System.out.println("enter your mobile Number");
					BufferedReader reader2=new BufferedReader(new InputStreamReader(System.in));
					String str = reader2.readLine();
					Customer fetched4=service.findbyMobileNo(str);
					System.out.println(fetched4.getName());
					System.out.println(fetched4.getBalance());
					break;
					
				case 2: //Recharge
					System.out.println("enter your mobile Number");
					BufferedReader reader3=new BufferedReader(new InputStreamReader(System.in));
					String s = reader3.readLine();
					System.out.println("enter recharge amount:");
					double amount;
				    amount = Double.parseDouble(reader3.readLine());
				    Customer fetched5=service.findbyMobileNo(s);
				    double bal=fetched5.getBalance();
				    Customer fetched6=service.rechargeAmount(s,bal,amount);
				   // System.out.println(fetched6.getName());
				   // System.out.println(fetched6.getBalance());
					break;
				case 3://Create account
					System.out.println("enter your mobile Number");
					BufferedReader reader4=new BufferedReader(new InputStreamReader(System.in));
					String c = reader4.readLine();
					System.out.println("enter recharge amount:");
					double a;
				    a = Double.parseDouble(reader4.readLine());
				    System.out.println("enter your name");
				    String n=reader4.readLine();
				     service.CreateAccount(c,n,a);
				     Customer c4=new Customer(c,n,a);
				    		  service.addCustomer(c4);
				   // Set<Customer> customers1= service.allCustomers();
				   //print(customers1);
					break;
				case 4://Exit
					System.out.println("application closes");
					System.exit(0);
					
				    
				    
						
					
			}
			
			
			
			}catch(Throwable e) {
				e.printStackTrace();
			}
		
	}


	private void print(Set<Customer> customers) {
		for (Customer c:customers){
	        System.out.println(c.getBalance()+"  "+c.getMobileNo()+"  "+c.getName());
	    }
		
	}
	}



