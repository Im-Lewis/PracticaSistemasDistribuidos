package es.ssdd.practica;

import es.ssdd.practica.Products.Product;
import es.ssdd.practica.Products.ProductService;
import es.ssdd.practica.Shop.Shop;
import es.ssdd.practica.Shop.ShopService;
import es.ssdd.practica.Tournament.Tournament;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataBaseInitializer {

    @Autowired
    ShopService shopService;

    @Autowired
    ProductService productService;

    @Autowired
    EntitiesService service;

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
        productService.createProduct(p1);
        productService.createProduct(p2);
        productService.createProduct(p3);
        productService.createProduct(p4);
        productService.createProduct(p5);
        productService.createProduct(p6);

        String imgUrl1 = "/images/shop3.jpg";
        String imgUrl2 = "/images/shop2.jpg";
        Shop s1 = new Shop("MePong Móstoles", "Móstoles", imgUrl1);
        Shop s2 = new Shop("MePong Pinto", "Pinto", imgUrl2);
        s1.setProduct(p1);
        s1.setProduct(p3);
        s2.setProduct(p6);
        s2.setProduct(p5);
        shopService.createShop(s1);
        shopService.createShop(s2);

        /* Default Tournaments, Organizers and Users */
        Tournament tournament1 = new Tournament("Torneo-1", "10/10/23", "10:10", "Pinto");
        Tournament tournament2 = new Tournament("Torneo-2", "11/10/23", "11:11", "Valdemoro");

        tournament1.setOrganizer(new TournamentOrganizer("Luis"));
        tournament2.setOrganizer(new TournamentOrganizer("Jaime"));

        service.createTournament(tournament1);
        service.createTournament(tournament2);
    }

}
