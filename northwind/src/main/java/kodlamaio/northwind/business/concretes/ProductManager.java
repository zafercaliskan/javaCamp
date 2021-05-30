package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@Service // Bu class projede servis görevi görecek diye spring'e bilgi veriyoruz.
public class ProductManager implements ProductService { //Asıl işi yaptığımız yer.

	private ProductDao productDao;

	// Bir instance oluşturuyor. Geçen hafta hibernate, inmemory gibi.
	// Bu instance buraya vereceğine dair bir bilgi yok. (constructor içinde
	// parametreler.
	// ep interface üzerinden gider.)
	// İşte bunu @Autowired anatsyonu ile yapıyoruz. Springden gelir. Beans görürsek
	// java class'ı dependency injection arkapalnda fabrika deseni çalıştırır
	// instance verir
	// Autowired dediğimizde spring gidip arkaplanda buna karşılık gelebilecek
	// ProductDao'nun
	// instance olabilecek bir sınıfı üretiyor ve onu veriyor. Spring tarfında
	// tanımlı.

	@Autowired // Java dünyasında çok popüler. productDao'u implemente eden somut sınıfı bulur onu newleyip atamasını yapar.
	public ProductManager(ProductDao productDao) { //constructor injection: bir baımlılığı constructor üzerinden injekte etmek. 
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data listelendi"); //Burada newlemenin bir sakıncası yoktur.
		//Çünkü burası bir bağımlılık oluşturmaz. Burada SuccessDataResult bize bir entity'nin dönüşünü anlatır.
		//Entity'e özeldir. Entity'in newlenmesinin bir sakıncası yoktur. Newlenebilir.
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data listelendi");	
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business codes
		
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory(productName,categoryId), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory(productName, categoryId), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"Data listelendi");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(), "Data listelendi");
	}
}