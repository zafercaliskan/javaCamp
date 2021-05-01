package interfaces;

public class Main {

	public static void main(String[] args) {
	
		Logger[] loggers= {new DatabaseLogger(), new SmsLogger()};
		CustomerManager customerManager= new CustomerManager(loggers);	
		Customer zafer = new Customer(1, "Zafer", "Çalýþkan");
		customerManager.add(zafer);

	}
}