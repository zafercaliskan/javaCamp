package oopIntro;

public class Main {

	public static void main(String[] args) {
		Product product1=new Product(1,"Lenevo",1600,"16 gb ram",10); //�rnek Olu�turma, referans olu�turma***, instance olu�turma		
		
		Product product2 = new Product(); //�rnek Olu�turma, referans olu�turma***, instance olu�turma		

		product2.setId(1);
		product2.setName("Lenevo 15");
		product2.setDetail("16 gb ram");
		product2.setDiscount(10);
		product2.setUnitPrice(16000);
		System.out.println(product2.getUnitPricAfterDiscount());
		
		ProductManager productManager = new ProductManager();
		productManager.addToCart(product1);
		
		Category category1=new Category();
		category1.setId(1);
		category1.setName("Bilgisayar");
		
		Category category2=new Category();
		category2.setId(0);
		category2.setName("Ev/Bah�e");
		
		System.out.println(category1.getName());
		System.out.println(category2.getName());
		
	}
}