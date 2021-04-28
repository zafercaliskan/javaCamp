package inheritance2;

public class CustomerManager {
	public void Add(Logger logger) { //burasý databaselogger'ý emaillogger'ý etc. alanbilir.
		System.out.println("Müþteri eklendi.");
		logger.log();
	}
}