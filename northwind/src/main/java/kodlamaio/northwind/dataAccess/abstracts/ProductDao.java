package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Product;

//Interface interface'i extend eder.
public interface ProductDao extends JpaRepository<Product, Integer>{

}