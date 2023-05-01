package es.ssdd.practica.Shop;

import es.ssdd.practica.Products.Product;
import es.ssdd.practica.ShopRepository;
import es.ssdd.practica.Tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ShopService {

    private AtomicLong id = new AtomicLong();
    @Autowired
    private ShopRepository shopRepository;

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Default shops */


    public Collection<Shop> getAll(){
        return shopRepository.findAll();
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to create a shop */
    public Shop createShop(Shop shop){
        long tem = id.incrementAndGet();
        shop.setId(tem);
        shopRepository.save(shop);
        return shop;
    }
    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to get a shop by id */
    public Shop getShopById(Long id){
        return shopRepository.getById(id);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* If the map contains a shop or not */
    public boolean containsShop(Long id){
        return shopRepository.existsById(id);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to delete a shop from the map */
    public Shop deleteShop(Long id){
        Shop shop = shopRepository.getById(id);
        shopRepository.deleteById(id);
        return shop;
    }


    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to add an edited shop again in the map */
    public Shop editShop(Long id, Shop shop){
        shopRepository.save(shop);
        return shop;
    }
}
