package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

public class ProductManager implements ProductService {
	private ProductDao productDao;

	public ProductManager(ProductDao productDao) { //Depenties injections (Gev�ek ba��ml�l�k loosely)
		super();
		this.productDao = productDao;
	}

	@Override
	public void add(Product product) {
		//�� Kodlar� yaz�l�r
		
		if(product.getCategoryId()==1) {
			System.out.println("Bu kategoride �r�n kabul edilmiyor.");
			return; //Buras� a�a��daki kodlara bakmaz d�ner.
		}

		this.productDao.add(product);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
