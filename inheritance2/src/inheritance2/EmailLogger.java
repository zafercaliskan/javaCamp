package inheritance2;

public class EmailLogger extends Logger{
	@Override //Javada yazmasakda olur. Ama kod okunurlu�u i�in yaz�l�r.
	public void log() {
		System.out.println("Email g�nderildi.");
	}
}
