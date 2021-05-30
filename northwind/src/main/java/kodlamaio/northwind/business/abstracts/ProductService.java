package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService { //controllerların kullanacağı operasyonları yazarız. 
	//İş katmanında sadece ve sadece iş kodları yazılır. 
	//ürün eklerken bir kuralımız varsa örneğin hepsiburada üretici ilk ay kendi ürününden fazla 100 tane ekleyebilir.
	DataResult<List<Product>> getAll(); //Burada success yada error olduğunu belirtmedik.
	Result add(Product product);
}