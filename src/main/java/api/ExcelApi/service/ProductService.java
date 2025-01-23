package api.ExcelApi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import api.ExcelApi.Repo.ProductRepo;
import api.ExcelApi.entity.Product;
import api.ExcelApi.helper.Helper;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public void Save (MultipartFile file) {
		
		try {
		List<Product> products = Helper.convertExcelToListOfProduct(file.getInputStream());
			
			this.productRepo.saveAll(products);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Product> getAllProducts (){
		
		return this.productRepo.findAll();
		
	}


}
