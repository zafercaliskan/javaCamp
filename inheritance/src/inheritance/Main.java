package inheritance;

public class Main {

	public static void main(String[] args) {
		IndividualCustomer zafer= new IndividualCustomer();
		zafer.customerNumber="123";
		
		CorporateCustomer aselsan=new CorporateCustomer();
		aselsan.customerNumber="456";
		
		Customer[] customers= { zafer, aselsan };
		CustomerManager customerManager=new CustomerManager();
		customerManager.AddMultiple(customers);
	}
}