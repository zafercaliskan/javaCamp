package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

//Interface interface'i extend eder.
public interface ProductDao extends JpaRepository<Product, Integer> {
	  
	Product getByProductName(String productName); //getBy görünce tablolara bakıyor. Tablodaki ilgili kolona göre where koşulu oluşturuyor.	  
	  
	Product getByProductNameAndCategory(String productName, int categoryId); //findBy getBy aynıdır. İkiside olur. ProductName 1. kolon CategoryId 2. kolon. 
		
	//Bizim yerimize "and" operatörü olan where koşulu yazıyor.
	  
	  
	List<Product> getByProductNameOrCategory(String productName, int categoryId);  //Burada hangi veri türünü döndürdüğümüz önemli. Yukarıda tek data getirirken burada birden fazla getirir.
		
	//"Or" operatörü olan where koşulu yazar. Yani 2 kolondan her hangi biriyle eşleşen koşul doğru olan alanları getirir.
	  
	  
	List<Product> getByCategoryIn(List<Integer> categories); //In birden fazla category id gönderip eşlesen tüm dataları getirebiliriz.
	  
	  
	List<Product> getByProductNameContains(String productName);
	  
	  
	List<Product> getByProductNameStartsWith(String productName); //Ürün isimleri verilen parametreye göre başlayan dataları getirir.
	  
	  
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")  //Burada veritabanında nasıl yazdığını unut. 
	  
	//Burada entities'de Product.javada nasıl verdiysen öyle kullanarak yazacaksın. select * 'a da gerek yok from ile başlıyoruz.
	  
	List<Product> getByNameAndCategory(String productName, int categoryId);
	  
	  
	//select * from products where product_name=bisey and categoryId=bisey -> bu sql sorgusu
}

// JpaRepository her nesneyle çalışabilecek bir yapıda. Yapılandırmaya göre çalışır.
// JpaRepository ne yapıyor? Verdiğin veri tipi için entity anatasyonu ile süslenmiş nesne için yani 
// Product için. Primary key alanınıda ver ki sorguları ve intelisence'i ona göre ayarlar.
// Primary key alanı integer olduğu için interger veririz.
//*** Product için crud operasyonlarımız hazır *** 

//Burada JpaRepository'ı extension'ı vasıtasıyla aslında hangi entity(tablo)'ya hangi id veri tipiyle 
//Sorguların hazırlanması gerektiğini Repository'e söylemiş oluyoruz