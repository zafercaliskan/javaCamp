package inheritance2;

public class FileLogger extends Logger{

	@Override //Javada yazmasakda olur. Ama kod okunurluðu için yazýlýr.
	public void log() { 
		System.out.println("File loglandý.");		
	}
}
