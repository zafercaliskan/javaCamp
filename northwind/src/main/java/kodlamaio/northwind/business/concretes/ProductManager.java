package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;


@Service //Bu class projede servis görevi görecek diye spring'e bilgi veriyoruz.
public class ProductManager implements ProductService {
	
	private ProductDao productDao;	

	//Bir instance oluşturuyor. Geçen hafta hibernate, inmemory gibi. 
	//Bu instance buraya vereceğine dair bir bilgi yok. (constructor içinde parametreler. 
	// ep interface üzerinden gider.) 
	//İşte bunu @Autowired anatsyonu ile yapıyoruz. Springden gelir. Beans görürsek
	//java class'ı dependency injection arkapalnda fabrika deseni çalıştırır instance verir
	//Autowired dediğimizde spring gidip arkaplanda buna karşılık gelebilecek ProductDao'nun
	//instance olabilecek bir sınıfı üretiyor ve onu veriyor. Spring tarfında tanımlı.
	
	@Autowired 	//Java dünyasında çok popüler.
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		return productDao.findAll();
	}
}