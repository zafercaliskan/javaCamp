package oopIntro;

public class Main {

	public static void main(String[] args) {
		Product product1=new Product(); //Örnek Oluþturma, referans oluþturma***, instance oluþturma		
		product1.id=1;
		product1.name="lenevo V14";
		product1.unitPrice=15000;
		product1.detail="16 gb ram";
		
		Product[] product= {
				product1				
		};
		System.out.println(product.length);
		
		Category category1=new Category();
		category1.id=1;
		category1.name="Bilgisayar";
		
		Category category2=new Category();
		category2.id=2;
		category2.name="Ev/Bahçe";
		
		ProductManager productManager=new ProductManager();
		productManager.addToCart(product1);
		
	}
}