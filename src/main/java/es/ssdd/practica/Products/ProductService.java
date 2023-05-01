package es.ssdd.practica.Products;

import es.ssdd.practica.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {
    private AtomicLong id = new AtomicLong();
    @Autowired
    private ProductRepository productRepository;

    public Collection<Product> getAll(){
        return productRepository.findAll();
    }
    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Default products */

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to create a product */
    public Product createProduct(Product product){
        long tem = id.incrementAndGet();
        product.setId(tem);
        productRepository.save(product);
        return product;
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to get a product by id */
    public Product getProductById(Long id){
        return productRepository.getById(id);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* If the map contains a tournament or not */
    public boolean containsProduct(Long id){
        return productRepository.existsById(id);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to delete a product from the map */
    public Product deleteProduct(Long id){
        Product product = productRepository.getById(id);
        productRepository.deleteById(id);
        return product;
    }


    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to add an edited product again in the map */
    public Product editTournament(Long id, Product product){
        productRepository.save(product);
        return product;
    }
}

