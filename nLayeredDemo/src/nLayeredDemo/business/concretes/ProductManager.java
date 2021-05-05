package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

public class ProductManager implements ProductService {
	private ProductDao productDao;
	private LoggerService loggerService;

	public ProductManager(ProductDao productDao, LoggerService loggerService) { //Depenties injections (Gevşek bağımlılık loosely)
		super();
		this.productDao = productDao;
		this.loggerService = loggerService;
		
	}

	@Override
	public void add(Product product) {
		//İş Kodları yazılır
		
		if(product.getCategoryId()==1) {
			System.out.println("Bu kategoride ürün kabul edilmiyor.");
			return; //Burası aşağıdaki kodlara bakmaz döner.
		}

		this.productDao.add(product);
		this.loggerService.logToSystem("Ürün eklendi. "+ product.getName());
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
