package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Product;

//Interface interface'i extend eder.
public interface ProductDao extends JpaRepository<Product, Integer>{ //JpaRepository her nesneyle çalışabilecek bir yapıda. Yapılandırmaya göre çalışır.
	// JpaRepository ne yapıyor? 
	// Verdiğin veri tipi için entity anatasyonu ile süslenmiş nesne için yani Product için 
	// Primary key alanınıda verki sorguları ve intelisence'i ona göre ayarlar.
	// Primary key alanı interger olduğu için interger veririz. 
}

//*** Product için crud operasyonlarımız hazır *** 


//Burada JpaRepository'ı extension'ı vasıtasıyla aslında hangi entity(tablo)'ya hangi id veri tipiyle 
//Sorguların hazırlanması gerektiğini Repository'e söylemiş oluyoruz.