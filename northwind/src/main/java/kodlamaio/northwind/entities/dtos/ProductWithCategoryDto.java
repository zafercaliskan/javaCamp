package kodlamaio.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto { //Tek tablo içinde kullanılabilir. Sadece belirli alanlarıg etirmek istediğimzide.
	private int id;
	private String productName;
	private String categoryName;
}