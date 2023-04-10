package es.ssdd.practica.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    /*private List<Product> listProducts = new ArrayList<>();

    public ProductController(){
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
        listProducts.add(p1);
        listProducts.add(p2);
        listProducts.add(p3);
        listProducts.add(p4);
        listProducts.add(p5);
        listProducts.add(p6);
    }*/

    @PostMapping("/product/added")
    public String addedProduct(Model model, Product product) {
        try{
            double num = Double.parseDouble(product.getPrecio());
            productService.createProduct(product);
            return "added_new_product";
        }catch (NumberFormatException e) {
            return "error_add_new_product";
        }

    }

    @GetMapping("/view/products")
    public String viewProducts(Model model){
        model.addAttribute("products", productService.getAll());
        return "view_new_products";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("products", productService.getAll());
        return "shop";
    }

    @GetMapping("/product/{num}")
    public String viewProduct(Model model, @PathVariable Long num){
        Product product = productService.getProductById(num);
        model.addAttribute("product", product);
        model.addAttribute("indice", num);
        return "view_product";
    }

    @GetMapping("/product/{num}/deleted")
    public String productDeleted(Model model, @PathVariable Long num){
        Product product = productService.deleteProduct(num);
        model.addAttribute("product", product);
        return "deleted_product";
    }

}