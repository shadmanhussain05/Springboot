package api.ExcelApi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import api.ExcelApi.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
