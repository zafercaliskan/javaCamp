package inheritance2;

public class CustomerManager {
	public void Add(Logger logger) { //buras� databaselogger'� emaillogger'� etc. alanbilir.
		System.out.println("M��teri eklendi.");
		logger.log();
	}
}