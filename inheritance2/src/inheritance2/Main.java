package inheritance2;

public class Main {

	public static void main(String[] args) {
		CustomerManager customerManager= new CustomerManager();
		customerManager.Add(new EmailLogger());
	}
}