package es.ssdd.practica;

import es.ssdd.practica.Products.Product;
import es.ssdd.practica.Products.ProductService;
import es.ssdd.practica.Shop.Shop;
import es.ssdd.practica.Shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataBaseInitializer {

    @Autowired
    ShopService shopService;

    @Autowired
    ProductService productService;

    @PostConstruct
    public void init() {
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

        String imgUrl1 = "/images/shop3.jpg";
        String imgUrl2 = "/images/shop2.jpg";
        Shop s1 = new Shop("MePong Móstoles", "Móstoles", imgUrl1);
        s1.getProducts().add(p1);
        s1.getProducts().add(p5);
        s1.getProducts().add(p6);
        Shop s2 = new Shop("MePong Pinto", "Pinto", imgUrl2);
        s2.getProducts().add(p2);
        s2.getProducts().add(p3);
        s2.getProducts().add(p4);
        s2.getProducts().add(p6);

        productService.createProduct(p1);
        productService.createProduct(p2);
        productService.createProduct(p3);
        productService.createProduct(p4);
        productService.createProduct(p5);
        productService.createProduct(p6);
        shopService.createShop(s1);
        shopService.createShop(s2);
    }

}
