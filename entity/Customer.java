package entity;



	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	public class Customer {
	      private String MobileNo;
		private String Name;
		private double Balance;

		public String getMobileNo() {
			return MobileNo;
		}

		public void setMobileNo(String mobileNo) {
			MobileNo = mobileNo;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public double getBalance() {
			return Balance;
		}

		public void setBalance(double Balance) {
			Balance = Balance;
		}

		
		public Customer(String MobileNo,String Name,double Balance) {
			this.MobileNo=MobileNo;
			this.Name=Name;
			this.Balance=Balance;
			}
		

		public Customer() {
			
		}

		public void Recharge(Customer c, double amount) {
						this.Balance=this.Balance+amount;
		}
		

		public void AddBalance() {
			BufferedReader reader1=new BufferedReader(new InputStreamReader(System.in));
		     System.out.println("enter MobileNo:");
		    
			try {
				MobileNo = reader1.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    System.out.println("enter recharge amount:");

		     double amount;
			try {
				amount = Double.parseDouble(reader1.readLine());
				this.Balance=this.Balance+amount;
			     System.out.println("Balance of the customer with"+MobileNo+" is   "+Balance);
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		    
		}
		
		public void createAccount() {
			BufferedReader reader2=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter MobileNo:");
			try {
				MobileNo = reader2.readLine();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			System.out.println("enter MobileNo:");
			try {
				Name=reader2.readLine();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			System.out.println("enter recharge amount:");
			double amount;
			try {
				amount = Double.parseDouble(reader2.readLine());
				this.Balance=this.Balance+amount;
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			Customer c4=new Customer(this.MobileNo,this.Name,this.Balance);
		}
		public void Exit() {
			BufferedReader reader3=new BufferedReader(new InputStreamReader(System.in));
			
			try {
				MobileNo = reader3.readLine();
				if(MobileNo=="E"){
					System.exit(1);
					System.out.println("exit...");
				}
				
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			
				
				
		}
	}


