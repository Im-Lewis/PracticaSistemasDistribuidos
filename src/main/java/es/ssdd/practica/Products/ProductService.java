package es.ssdd.practica.Products;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {
    private static Map<Long, Product> productMap = new ConcurrentHashMap<>();

    private AtomicLong id = new AtomicLong();

    public static Collection<Product> getAll(){
        return productMap.values();
    }
    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Default products */
    String imageURL1 = "/images/kit.png";
    String imageURL2 = "/images/mesabasica.png";
    String imageURL3 = "/images/mesapalatronix.png";
    String imageURL4 = "/images/bolapingpong.png";
    String imageURL5 = "/images/red.png";
    String imageURL6 = "/images/palapro.png";
    Product p1 = new Product("KIT PINGPONG", "Kit", "19.99", "Disfruta de este maravilloso kit junto a un amigo con hasta tres bolas", imageURL1);
    Product p2 = new Product("MESA BÁSICA", "Mesa", "209.99", "¡No dudes en llevarte esta mesa para disfutar del ping pong!", imageURL2);
    Product p3 = new Product("MESA PALATRONIX", "Mesa", "319.99", "Último modelo de la marca más prestigiosa de Ping Pong, Palitronix", imageURL3);
    Product p4 = new Product("BOLA", "Bolas", "0.99", "Se venden por unidades las bolas. Bolas de la marca Palatronix", imageURL4);
    Product p5 = new Product("RED MESA CASERA", "Equipamiento", "10.99", "Disfruta desde cualquier sitio con esta red", imageURL5);
    Product p6 = new Product("PALA PRO", "Pala", "10.99", "Con nuestra última pala, ten claro que ahora esta pala nos será tu excusa", imageURL6);

    public ProductService(){
        createProduct(p1);
        createProduct(p2);
        createProduct(p3);
        createProduct(p4);
        createProduct(p5);
        createProduct(p6);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to create a product */
    public Product createProduct(Product product){
        long tem = id.incrementAndGet();
        product.setId(tem);
        productMap.put(tem, product);
        return product;
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to get a product by id */
    public Product getProductById(Long id){
        return productMap.get(id);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* If the map contains a tournament or not */
    public boolean containsProduct(Long id){
        return productMap.containsKey(id);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to delete a product from the map */
    public Product deleteProduct(Long id){
        return productMap.remove(id);
    }


    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Function to add an edited product again in the map */
    public Product editTournament(Long id, Product product){
        productMap.put(id, product);
        return product;
    }
}

