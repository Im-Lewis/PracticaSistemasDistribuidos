package es.ssdd.practica.Shop;

import es.ssdd.practica.Products.Product;
import es.ssdd.practica.Tournament.Tournament;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ShopService {

    private Map<Long, Shop> shopMap = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong();

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Default shops */
    String imageUrl1 = "/images/shop3.jpg";
    String imageUrl2 = "/images/shop2.jpg";
    Shop s1 = new Shop("MePong Móstoles", "Móstoles", imageUrl1);
    Shop s2 = new Shop("MePong Pinto", "Pinto", imageUrl2);

    public ShopService(){
        createShop(s1);
        createShop(s2);
    }

    public Collection<Shop> getAll(){
        return shopMap.values();
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to create a shop */
    public Shop createShop(Shop shop){
        long tem = id.incrementAndGet();
        shop.setId(tem);
        shopMap.put(tem, shop);
        return shop;
    }
    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to get a shop by id */
    public Shop getShopById(Long id){
        return shopMap.get(id);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* If the map contains a shop or not */
    public boolean containsShop(Long id){
        return shopMap.containsKey(id);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to delete a shop from the map */
    public Shop deleteShop(Long id){
        return shopMap.remove(id);
    }


    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to add an edited shop again in the map */
    public Shop editShop(Long id, Shop tournament){
        shopMap.put(id, tournament);
        return tournament;
    }
}
