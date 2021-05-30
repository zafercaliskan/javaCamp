package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok. getter setter
@AllArgsConstructor // Tüm parametreleri kullanrak consructor oluşturur.
@NoArgsConstructor // Parametresiz consructor oluşturur.
@Table(name = "categories") // Veri tabanıyla ilişkilendiriyoruz.
@Entity // Veri tabanı tablosunu olduğunu anlatmak için kullandığımız anatasyon.
public class Category {
	@Id //veri tabanında kategoriler otomatik artmıyor. Ama idyi vermek gerekiyor. İlişkilendirme yaptık...
	@Column(name = "category_id")
	private int catergoryId;

	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(mappedBy = "categories") //products'ı categories ile ilişkilendiriyor.
	// Burası ana tablo. Birden çoka bir ilişki var.
	// Product tablosunda aynı categor_id'den birden fazla kez olabilir.
	private List<Product> products; //product tablosundan buraya ilişki atarken many to one yapacağız.
	
	//Yukarıdaki olay kategorinin ürünleri. Yani 1den çoka.
}

//one to many -> Ana tabloda 1 kere geçer. Diğer tabloda çok kere geçebilir.
//one to one  -> Ana tabloda 1 kere geçer. Diğer tabloda da 1 kere geçebilir.