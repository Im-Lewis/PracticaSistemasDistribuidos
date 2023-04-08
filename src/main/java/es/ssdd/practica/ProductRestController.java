package es.ssdd.practica;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest/product")
public class ProductRestController {

    private Map<Integer, Product> mapProducts = new HashMap<>();
    private int lastId;

    @GetMapping("/")
    public Collection<Product> getAllProducts(){
        return mapProducts.values();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        lastId++;
        int id = lastId;
        product.setId(id);
        mapProducts.put(id, product);
        return product;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getItem(@PathVariable int id) {

        Product product = mapProducts.get(id);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteItem(@PathVariable int id) {

        Product product = mapProducts.remove(id);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateItem(@PathVariable int id, @RequestBody Product newProduct) {

        Product oldProduct = mapProducts.get(id);

        if (oldProduct != null) {
            newProduct.setId(id);
            mapProducts.put(id, newProduct);
            return new ResponseEntity<>(newProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}