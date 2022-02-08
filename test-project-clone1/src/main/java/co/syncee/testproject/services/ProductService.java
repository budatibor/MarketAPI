package co.syncee.testproject.services;
import co.syncee.testproject.model.Product;
import co.syncee.testproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Component inject dependency in the API method.. or:
@Service
public class ProductService
{
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product)
    {
        Optional<Product> productByName =
            productRepository.findProductByName(product.getName());
        if (productByName.isPresent())
            throw new IllegalStateException("Product already exists");
        productRepository.save(product);
    }

    public void deleteProduct(String productName) {
        Optional<Product> productByName =
        productRepository.findProductByName(productName);
        if (productByName.isEmpty())
        {
            throw new IllegalStateException("Product does not exists");
        }
        productRepository.delete(productByName.get());

    }
}
