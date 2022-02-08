package co.syncee.testproject.controller;

import co.syncee.testproject.model.Product;
import co.syncee.testproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/product/")
public class ProductController {

    private final ProductService productService;

    @Autowired //for dependency injection purposes
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product)
    {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productName}")
    public void deleteProduct(@PathVariable("productName") String productName)
    {
        productService.deleteProduct(productName);
    }
}
