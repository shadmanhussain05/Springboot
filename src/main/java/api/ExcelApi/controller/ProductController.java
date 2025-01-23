package api.ExcelApi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import api.ExcelApi.entity.Product;
import api.ExcelApi.helper.Helper;
import api.ExcelApi.service.ProductService;

@Controller
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		
		if(Helper.checkExcelFormate(file)) {
			
			// true
			
			this.productService.Save(file);
			
			return ResponseEntity.ok(Map.of("message","file is uploaded and data is saved to db"));
			
			
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file");
	}
	
	@GetMapping("/product")
	public List<Product> getAlProducts(){
		return this.productService.getAllProducts();
	}
}
