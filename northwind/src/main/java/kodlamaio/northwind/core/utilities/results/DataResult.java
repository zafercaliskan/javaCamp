package kodlamaio.northwind.core.utilities.results;

public class DataResult<T> extends Result { //T Döndüreceği data tipini olur. 

	private T data;
	public DataResult(T data, boolean success, String message) {
		super(success, message); //Bu super ile base'in consructorlarını çalıştırmaya yarıyor.
		this.data=data;
	}
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data=data;
	}
	
	public T getData() {
		return this.data;
	}
}