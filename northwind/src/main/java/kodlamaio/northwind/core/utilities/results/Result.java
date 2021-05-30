package kodlamaio.northwind.core.utilities.results;

public class Result {
	private boolean success;

	private String message;

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success); //şuanki mevcut class demek. Kendimizi tekrar etmiyoruz.
		//Yukarı satırda bu classın consructor'ı hangisi tek parametreli olanı çağırmış oluyoruz.
		this.message = message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}

}
