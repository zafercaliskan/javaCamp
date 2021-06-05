package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

//Bunların hepsi springden geliyor.
@RestController //Sen bir controllersın demek. Her iş yapan sınıflara anatayon ekledik. Entity, Service etc. Java olmayanlarda tanısın diye RestController tanımlarız.
@RequestMapping("/api/products") //Farklı controllerlar olabilir.   domain'imizin sonuna /api/products'a bir istek gelirse bu controller'a erişir.
//karşılayacak budur demiş oluyoruz.
@CrossOrigin
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired //productService lazım diyor. Projeyi tarıyor. Kim productService'i implements etmiş bakıyor.
	//productService'i productmanager implement ettiğini buluyor. Arka planda ProductManager'ı newliyor.
	//Onu newlerken productDao'ya ihtiyacaç duyuyor onuda newliyor. Newlenmiş productmanager'i alt satırdaki
	//ProductService productService'e yerleştiriyor. Bizim newlememize gerek kalmıyor.
	public ProductsController(ProductService productService) { //productService bir interface. Tek başına bir anlamı yok. Fakat referans tutucu olması itibariyle bu adam 
		//manager'ı tutabilir. Çünkü kendisinden implemente edilen classları tutabilir.  @Autowired da tüm projeyi gezer o interface'i implementye eden classı managerı bulur 
		// onu newler o referansı productService' arkadaşına atar.
		super();
		this.productService = productService;
	}
	
	//buradaki problem birden fazla somut sınıf varsa @Autowired patlar. Onu ilerleyen derslerde handle edeceğiz.
	//Java dünyasıonda oturmuş sistem böyle. Solid zafiyet, var burada.


	@GetMapping("/getall") //kodlama.io/api/products/getall'e istek gelince burası çalışır.
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
}