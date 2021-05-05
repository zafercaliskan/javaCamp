package nLayeredDemo.jLogger;

public class JLoggerManager { //simülasyon amaçlı bir başkasının yazdığı library kullanıyormuşuz düşünelim.
	public void log(String message) { //micro service mimarileride bu şekilde injecte edilir. 
		System.out.println("J Logger ile loglandı. " + message);
	}

}
