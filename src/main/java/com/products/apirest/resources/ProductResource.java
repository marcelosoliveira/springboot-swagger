package com.products.apirest.resources;

import com.products.apirest.models.Products;
import com.products.apirest.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Products")
@CrossOrigin(value = "*")
public class ProductResource {
  @Autowired
  ProductRepository productRepository;

  @GetMapping("/products")
  @ApiOperation(value = "Return list of products")
  public List<Products> productsList() {
    return productRepository.findAll();
  }

  @GetMapping("/products/{id}")
  @ApiOperation(value = "Return unique product")
  public Products productsListUnique(@PathVariable(value = "id") long id) {
    return productRepository.findById(id);
  }

  @PostMapping("/products")
  @ApiOperation(value = "Insert product")
  public Products saveProducts(@RequestBody Products products) {
    return productRepository.save(products);
  }

  @PutMapping("/products")
  @ApiOperation(value = "Update product")
    public Products updateProducts(@RequestBody Products products) {
      return productRepository.save(products);
    }

  @DeleteMapping("/products/{id}")
  @ApiOperation(value = "Delete product")
  public void deleteProducts(@PathVariable(value = "id") long id) {
   productRepository.deleteById(id);
  }
}
