package kodlamaio.northwind.core.utilities.results;

public class ErrorResult extends Result { //ErrorResult ise başarısız demektir.
	public ErrorResult() {
		super(false);
	}

	public ErrorResult(String message) {
		super(false, message);
	}
}