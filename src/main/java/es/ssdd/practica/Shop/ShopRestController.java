package es.ssdd.practica.Shop;

import es.ssdd.practica.Products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/shops")
public class ShopRestController {

    @Autowired
    ShopService shopService;

    @GetMapping("/")
    public ResponseEntity<Collection<Shop>> getAllShops(){
        return new ResponseEntity(shopService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShop(@PathVariable Long id) {

        boolean contains = shopService.containsShop(id);

        if (contains) {
            return new ResponseEntity<>(shopService.getShopById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> deleteShop(@PathVariable Long id) {

        boolean contains = shopService.containsShop(id);

        if (contains) {
            Shop shop = shopService.deleteShop(id);
            return new ResponseEntity<>(shop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Long id, @RequestBody Shop newShop) {

        Optional<Shop> oldShop = shopService.getShopById(id);

        if (oldShop.isPresent()) {
            shopService.editShop(id, newShop);
            return new ResponseEntity<>(newShop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
