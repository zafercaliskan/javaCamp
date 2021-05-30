package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column; //Jpa alt yapısını kullanır.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok: getter setter
@Entity //Anatasyon: Anatasyon nedir? - Aslında bir class'ın çalışma anında veya derleme
//anında onunla bilgi toplama için yapılan bir yapı. C# karşılığı: attribute. 
//Burada product bir entitydir bir veri tabanı nesnesidir diyoruz.
@Table(name = "products") //Veri tabanında hangi tabloya karşılık geldiğini ve hangi tablo olduğunu söylüyoruz. //C#da attribüte
@AllArgsConstructor
@NoArgsConstructor
public class Product {	    
	@Id  //Tablodaki id alanın ne olduğunu söylemek gerekiyor. İşlemlerini idye göre yapacak.
	//Veri tabanında id alanları: bazen manuel, bazen otomatik, bazen oracle tarafında...
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Bir bir artırılacağını söyledik.	    
	@Column(name="product_id") //Veri tabanında hangi kolona karşılık geldiğini söylüyoruz.		
	private int id;	    
	    
	//@Column(name="category_id") //Aşağıda belirttiğiiz için burada gerek yok.		
	//private int categoryId;	    
	    
	@Column(name="product_name")		
	private String productName;	    
	    
	@Column(name="unit_price")		
	private double unitPrice;	    
	    
	@Column(name="units_in_stock")
	private short unitsInStock;	    
	   
	@Column(name="quantity_per_unit")		
	private String quantityPerUnit;	    
	    
	@ManyToOne()	    
	@JoinColumn(name="category_id") //Hangi kolon ile ilişkilendirileceğini söyledik. 
	//Bu hareketi yapınca aslında biz bu product'ın category'si nedir yapmış oluyoruz.Yani en yukarıdaki category_id alanını tutmaya gerek yok.	    
	private Category category;
	//Category'nin yani ana tablonun products ile ilgili hiçbir bilgisi yok. Biz join'i category_id ile yapıyoruz. 
	// İlişkilendirildiği anda maplemiş olacağız. 
}