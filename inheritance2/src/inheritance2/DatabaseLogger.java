package inheritance2;

public class DatabaseLogger extends Logger {
	@Override //Javada yazmasakda olur. Ama kod okunurluðu için yazýlýr.
	public void log() {
		System.out.println("Database loglandý.");
	}
}
