package es.ssdd.practica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private List<Product> listProducts;

    public ProductController(){
        listProducts = new ArrayList<>();
    }



    @GetMapping("/product/created")
    public String getProducts(Model model){
        model.addAttribute("products", listProducts);
        return "added_new_product";
    }

    @PostMapping("/product/add")
    public String newProduct(Model model, @RequestParam String name, @RequestParam String tag,
                             @RequestParam float price, @RequestParam String description){
        Product product = new Product(name, tag, price, description);

        listProducts.add(product);

        return "shop";

    }
}
