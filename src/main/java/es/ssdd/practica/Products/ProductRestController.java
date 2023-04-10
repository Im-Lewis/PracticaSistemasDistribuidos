package es.ssdd.practica.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Collection<Product>> getAllProducts(){
        return new ResponseEntity(productService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity createProduct(@RequestBody Product product){
        Product p = productService.createProduct(product);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getItem(@PathVariable Long id) {

        boolean contains = productService.containsProduct(id);

        if (contains) {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteItem(@PathVariable Long id) {

        boolean contains = productService.containsProduct(id);

        if (contains) {
            Product product = productService.deleteProduct(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateItem(@PathVariable Long id, @RequestBody Product newProduct) {

        Product oldProduct = productService.getProductById(id);

        if (oldProduct != null) {
            productService.editTournament(id, newProduct);
            return new ResponseEntity<>(newProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}