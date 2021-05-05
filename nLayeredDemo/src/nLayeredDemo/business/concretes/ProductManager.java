package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

public class ProductManager implements ProductService {
	private ProductDao productDao;

	public ProductManager(ProductDao productDao) { //Depenties injections (Gevþek baðýmlýlýk loosely)
		super();
		this.productDao = productDao;
	}

	@Override
	public void add(Product product) {
		//Ýþ Kodlarý yazýlýr
		
		if(product.getCategoryId()==1) {
			System.out.println("Bu kategoride ürün kabul edilmiyor.");
			return; //Burasý aþaðýdaki kodlara bakmaz döner.
		}

		this.productDao.add(product);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
